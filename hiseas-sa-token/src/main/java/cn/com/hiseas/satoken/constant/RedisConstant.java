package cn.com.hiseas.satoken.constant;

/**
 * SaToken 缓存相关常量
 *
 * @author zhengxiang
 * @date 2025/1/16 00:48
 * @since 0.0.1
 */
public interface RedisConstant {

    /**
     * 角色-权限 缓存key前缀
     */
    String ROLE_PERMISSIONS_PREFIX = "role:permissions";

    /**
     * 用户-角色 缓存key前缀
     */
    String USER_ROLES_PREFIX = "user-roles-";

}
