package cn.com.hiseas.center.user.api;

import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhengxiang
 * @version 1.0
 
 */
@FeignClient(
        contextId = "cn-com-hiseas-user-api-IPermissionApi",
        name = "${cn.com.hiseas.user.api.name:user-service}",
        path = "/api/permissions",
        url = "${cn.com.hiseas.user.api:}"
)
public interface IPermissionApi {

    @GetMapping
    List<PermissionRespDto> loadPermissionsByRoleId(@RequestParam("roleId") Integer roleId);

}
