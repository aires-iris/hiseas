package cn.com.hiseas.center.user.controller;

/**
 * @author zhengxiang
 * @version 1.0
 */

import cn.com.hiseas.center.user.api.IPermissionApi;
import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import cn.com.hiseas.center.user.service.PermissionService;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController implements IPermissionApi {


    private final PermissionService permissionService;


    @SaIgnore
    @GetMapping
    public List<PermissionRespDto> loadPermissionsByRoleId(@RequestParam("roleId") Integer roleId) {
        return permissionService.loadPermissionsByRoleId(roleId);
    }
}
