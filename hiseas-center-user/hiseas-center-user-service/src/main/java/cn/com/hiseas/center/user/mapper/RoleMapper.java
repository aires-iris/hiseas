package cn.com.hiseas.center.user.mapper;

import cn.com.hiseas.center.user.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.sa.user.domain.Role
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    // 通过用户ID加载角色列表
    @Select("SELECT r.* FROM roles r INNER JOIN user_roles ur ON r.id = ur.role_id WHERE ur.user_id = #{userId}")
    List<Role> loadRolesByUserId(Long userId);

    // 获得所有的角色
    @Select("SELECT * FROM roles")
    List<Role> loadAllRoles();

}




