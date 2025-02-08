package cn.com.hiseas.center.user.service;

import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.center.user.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface RoleService extends IService<Role> {

    List<RoleRespDto> loadRoleByUserId(long userId);

    List<RoleRespDto> loadAllRoles();
}
