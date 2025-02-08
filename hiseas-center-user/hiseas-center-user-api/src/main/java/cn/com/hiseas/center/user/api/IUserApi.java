package cn.com.hiseas.center.user.api;

import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.dev33.satoken.util.SaResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhengxiang
 * @version 1.0
 */
@FeignClient(
        contextId = "cn-com-hiseas-user-api-IUserApi",
        name = "${cn.com.hiseas.user.api.name:user-service}",
        path = "/api/users",
        url = "${cn.com.hiseas.user.api:}"
)
public interface IUserApi {
    @PostMapping("/login")
    SaResult login(@RequestBody UserRespDto userRespDto);
}
