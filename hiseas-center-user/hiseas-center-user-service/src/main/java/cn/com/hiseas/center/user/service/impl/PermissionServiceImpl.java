package cn.com.hiseas.center.user.service.impl;

import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import cn.com.hiseas.center.user.converter.PermissionConvertor;
import cn.com.hiseas.center.user.domain.Permission;
import cn.com.hiseas.center.user.mapper.PermissionMapper;
import cn.com.hiseas.center.user.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    private final PermissionConvertor permissionConvertor;
    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionRespDto> loadPermissionsByRoleId(Integer roleId) {
        List<Permission> permissions = permissionMapper.loadPermissionsByRoleId(roleId);
        if (permissions != null && !permissions.isEmpty()) {
            return permissions.stream().map(permission -> permissionConvertor.toDTO(permission)).toList();
        }
        return null;
    }
}




