package cn.com.hiseas.iam.service.impl;

import cn.com.hiseas.center.user.api.IRoleApi;
import cn.com.hiseas.center.user.api.IUserApi;
import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.com.hiseas.common.constant.RedisConstant;
import cn.com.hiseas.iam.dto.LoginDTO;
import cn.com.hiseas.iam.service.AuthService;
import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final IUserApi userApi;
    private final IRoleApi roleApi;
    private final RedisTemplate redisTemplate;

    private static final Long USER_ROLES_EXPIRE_TIME = 60 * 60 * 24L;

    @Override
    public SaResult login(LoginDTO loginDTO) {
        UserRespDto userDTO = parseToUserDTO(loginDTO);
        try {
            SaResult response = userApi.login(userDTO);

            if (response.getCode() == SaResult.CODE_SUCCESS) {
                // 用户验证成功
                UserRespDto user = new ObjectMapper().convertValue(response.getData(), UserRespDto.class);

                // 使用 Sa-Token 进行登录
                StpUtil.login(user.getId(), SaLoginConfig.setExtra("fullName", user.getFullName()));

                // 用户登录成功之后，缓存维护用户-角色数据 (该接口需要忽略登录校验)
                List<RoleRespDto> roleDTOList = roleApi.loadRoles(user.getId());
                List<String> roleNames = roleDTOList.stream().map(RoleRespDto::getCode).collect(Collectors.toList());
                // 将角色名称信息存入 Redis    user-roles-1  ,  [管理员,技术总监]
                redisTemplate.opsForValue().set(RedisConstant.Auth.USER_ROLES_PREFIX + user.getId(), roleNames, USER_ROLES_EXPIRE_TIME, TimeUnit.SECONDS);
                return SaResult.ok("登录成功");
            } else {
                return SaResult.error(response.getMsg());
            }
        } catch (Exception e) {
            log.error("Error during login request", e);
            return SaResult.error("Server error: " + e.getMessage());
        }
    }

    private UserRespDto parseToUserDTO(LoginDTO loginDTO) {
        UserRespDto userDTO = new UserRespDto();
        userDTO.setUsername(loginDTO.getUsername());
        userDTO.setPassword(loginDTO.getPassword());
        return userDTO;
    }


}
