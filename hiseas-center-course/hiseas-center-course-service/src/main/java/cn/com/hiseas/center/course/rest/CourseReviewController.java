package cn.com.hiseas.center.course.rest;

import cn.com.hiseas.center.course.api.ICourseReviewApi;
import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.center.course.service.CourseReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Architecture Station
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/courseReview")
@Slf4j
public class CourseReviewController implements ICourseReviewApi {

    @Resource
    private CourseReviewService courseReviewService;


    @Override
    public ResponseEntity<?> createCourseReview(CourseReviewRespDto courseReviewReqDto) {
        return new ResponseEntity<>(courseReviewService.createCourseReview(courseReviewReqDto));
    }
}
