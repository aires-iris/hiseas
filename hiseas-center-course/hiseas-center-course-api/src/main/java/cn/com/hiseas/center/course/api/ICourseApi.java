package cn.com.hiseas.center.course.api;

import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * desc
 *
 * @author zhengxiang
 * @since 0.0.1
 */
@FeignClient(
        contextId = "cn-com-hiseas-course-api-ICourseApi",
        name = "${cn.com.hiseas.course.api.name:https://course-service}",
        path = "/api/course",
        url = "${cn.com.hiseas.course.api:}"
)
public interface ICourseApi {

    /**
     * 根据课程id获取课程信息
     *
     * @param courseId 课程id
     * @return 课程详情
     */
    @GetMapping("/{courseId}")
    ResponseEntity<CourseRespDto> getCourse(@PathVariable("courseId") Long courseId);

}
