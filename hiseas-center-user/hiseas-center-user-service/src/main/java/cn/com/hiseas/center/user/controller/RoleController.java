package cn.com.hiseas.center.user.controller;

/**
 * @author zhengxiang
 * @version 1.0
 */

import cn.com.hiseas.center.user.api.IRoleApi;
import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.center.user.service.RoleService;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController implements IRoleApi {

    @Resource
    private final RoleService roleService;


    @SaIgnore
    @GetMapping("/{userId}/roles")
    public List<RoleRespDto> loadRoles(@PathVariable long userId) {
        return roleService.loadRoleByUserId(userId);
    }

    // 获取所有角色
    @GetMapping
    @SaIgnore
    public List<RoleRespDto> loadAllRoles() {
        // 从数据库或其他源获取所有角色数据
        return roleService.loadAllRoles();
    }
}
