package cn.com.hiseas.center.user.api;

import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhengxiang
 * @version 1.0
 */
@FeignClient(
        contextId = "cn-com-hiseas-user-api-IRoleApi",
        name = "${cn.com.hiseas.user.api.name:user-service}",
        path = "/api/role",
        url = "${cn.com.hiseas.user.api:}"
)
public interface IRoleApi {

    @GetMapping("/{userId}/roles")
    List<RoleRespDto> loadRoles(@PathVariable long userId);

    @GetMapping
    List<RoleRespDto> loadAllRoles();
}
