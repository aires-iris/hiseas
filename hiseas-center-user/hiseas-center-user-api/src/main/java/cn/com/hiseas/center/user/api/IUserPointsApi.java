package cn.com.hiseas.center.user.api;

import cn.com.hiseas.center.user.dto.response.UserPointsRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhengxiang
 * @version 1.0
 */
@FeignClient(
        contextId = "cn-com-hiseas-user-api-IUserPointsApi",
        name = "${cn.com.hiseas.user.api.name:user-service}",
        path = "/api/userScore",
        url = "${cn.com.hiseas.user.api:}"
)
public interface IUserPointsApi {

    @PutMapping
    ResponseEntity<?> accumulateUserPoints(@RequestBody UserPointsRespDto userPointsRespDto);
}
