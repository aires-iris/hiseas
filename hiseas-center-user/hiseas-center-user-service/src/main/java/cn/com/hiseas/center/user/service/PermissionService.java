package cn.com.hiseas.center.user.service;

import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import cn.com.hiseas.center.user.domain.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PermissionService extends IService<Permission> {

    List<PermissionRespDto> loadPermissionsByRoleId(Integer roleId);
}
