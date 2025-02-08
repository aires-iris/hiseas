package cn.com.hiseas.center.user.service.impl;

import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.center.user.converter.RoleConvertor;
import cn.com.hiseas.center.user.domain.Role;
import cn.com.hiseas.center.user.mapper.RoleMapper;
import cn.com.hiseas.center.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;
    private final RoleConvertor roleConvertor;

    @Override
    public List<RoleRespDto> loadRoleByUserId(long userId) {
        List<Role> roles = roleMapper.loadRolesByUserId(userId);
        if (roles != null && !roles.isEmpty()) {
            return roles.stream().map(roleConvertor::toDTO).toList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<RoleRespDto> loadAllRoles() {
        log.info("loadAllRoles........");
        List<Role> roles = roleMapper.loadAllRoles();
        if (roles != null && !roles.isEmpty()) {
            return roles.stream().map(roleConvertor::toDTO).toList();
        }
        return null;
    }
}




