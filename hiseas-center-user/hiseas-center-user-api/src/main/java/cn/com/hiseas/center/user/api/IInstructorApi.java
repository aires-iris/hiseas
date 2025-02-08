package cn.com.hiseas.center.user.api;

import cn.com.hiseas.center.user.dto.response.InstructorRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        contextId = "cn-com-hiseas-user-api-IInstructorApi",
        name = "${cn.com.hiseas.user.api.name:user-service}",
        path = "/api/instructors",
        url = "${cn.com.hiseas.user.api:}"
)
public interface IInstructorApi {

    @GetMapping("/{instructorId}")
    ResponseEntity<InstructorRespDto> getInstructorById(@PathVariable Long instructorId);
}