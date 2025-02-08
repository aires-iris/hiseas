package cn.com.hiseas.iam.config;


import cn.com.hiseas.center.user.api.IPermissionApi;
import cn.com.hiseas.center.user.api.IRoleApi;
import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.common.constant.RedisConstant;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * [角色,权限列表] 的缓存在认证中心启动进行初始化,放入缓存
 * [用户,角色列表] 的缓存在登录后放入缓存
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class RolePermissionInitializer {

    private final IRoleApi roleApi;
    private final IPermissionApi permissionApi;
    private final RedisTemplate<String, Object> redisTemplate;


    @PostConstruct
    void init() {
        log.info("开始初始化[角色,权限列表]到缓存中....");
        try {
            initRolePermissions();
        } catch (Exception e) {
            log.error("初始化[角色,权限列表]到缓存失败:{}", e.getMessage());
        }
    }

    private void initRolePermissions() {
        List<RoleRespDto> allRoles = roleApi.loadAllRoles();
        log.info("allRoles:{}", allRoles);
        for (RoleRespDto role : allRoles) {
            List<PermissionRespDto> permissionDTOS = permissionApi.loadPermissionsByRoleId(role.getId());
            if (CollectionUtil.isNotEmpty(permissionDTOS)) {
                List<String> permissions = permissionDTOS.stream().map(PermissionRespDto::getName).toList();
                log.info("role:{} has permissions:{}", role, permissions);
                try {
                    redisTemplate.opsForHash().put(RedisConstant.Auth.ROLE_PERMISSIONS_PREFIX, role.getCode(), JSONObject.toJSONString(permissions));
                    log.info("cached role {} permissions in Redis!", role.getName());
                } catch (Exception e) {
                    log.info("cache role {} permissions Failed!\n{}", role.getName(), e.getMessage());
                }
            } else {
                log.warn("role {} has none permissions", role.getCode());
            }
        }
        log.info("all role with permissions has cached!");
    }
}
