package cn.com.hiseas.center.user.mapper;

import cn.com.hiseas.center.user.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.sa.user.domain.Permission
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    // 通过角色ID获得权限列表
    @Select("SELECT * FROM permissions WHERE id IN (SELECT permission_id FROM role_permissions WHERE role_id = #{roleId}) ORDER BY id")
    public List<Permission> loadPermissionsByRoleId(Integer roleId);

}




