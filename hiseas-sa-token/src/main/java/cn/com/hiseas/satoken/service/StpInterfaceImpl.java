package cn.com.hiseas.satoken.service;

import cn.com.hiseas.satoken.constant.RedisConstant;
import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollUtil;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * 自定义 权限加载 实现类
 *
 * @author zhengxiang
 * @date 2025/1/16 00:53
 * @since 0.0.1
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 返回登录账号的所有权限集合
     *
     * @param loginId   登录用户id
     * @param loginType 登录类型
     * @return 权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> roleList = getRoleList(loginId, loginType);
        HashSet<String> permissionSet = new HashSet<>();
        if (CollUtil.isNotEmpty(roleList)) {
            roleList.forEach(e -> {
                Object value = redisTemplate.opsForValue().get(RedisConstant.ROLE_PERMISSIONS_PREFIX + e);
                if (Objects.nonNull(value)) {
                    List<String> permissions = new Gson().fromJson(value.toString(), List.class);
                    permissionSet.addAll(permissions);
                }
            });
            return List.copyOf(permissionSet);
        }
        return List.of();
    }

    /**
     * 返回登录账号的所有角色集合
     *
     * @param loginId   登录用户id
     * @param loginType 登录类型
     * @return 角色集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        String cacheKey = RedisConstant.USER_ROLES_PREFIX + loginId;
        if (redisTemplate.hasKey(cacheKey)) {
            return (List<String>) redisTemplate.opsForValue().get(cacheKey);
        }
        return List.of();
    }
}
