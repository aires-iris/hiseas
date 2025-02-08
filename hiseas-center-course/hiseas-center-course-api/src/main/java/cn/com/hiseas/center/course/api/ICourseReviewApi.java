package cn.com.hiseas.center.course.api;

import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * desc
 *
 * @author zhengxiang
 * @date 2025/1/16 01:25
 * @since 0.0.1
 */
@FeignClient(
        contextId = "cn-com-hiseas-course-api-ICourseReviewApi",
        name = "${cn.com.hiseas.course.api.name:course-service}",
        path = "/api/courseReview",
        url = "${cn.com.hiseas.course.api:}"
)
public interface ICourseReviewApi {

    /**
     * 创建课程评论
     *
     * @param courseReviewReqDto 课程评论参数
     * @return id
     */
    @PostMapping
    ResponseEntity<?> createCourseReview(@RequestBody CourseReviewRespDto courseReviewReqDto);
}
