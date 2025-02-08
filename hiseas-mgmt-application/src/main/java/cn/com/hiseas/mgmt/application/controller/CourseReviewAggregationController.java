package cn.com.hiseas.mgmt.application.controller;

import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.mgmt.application.service.CourseAggregationReviewService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Architecture Station
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/courseReview")
@Slf4j
public class CourseReviewAggregationController {

    @Resource
    private CourseAggregationReviewService courseReviewService;

    // 插入课程评论
    @PostMapping
    public ResponseEntity<?> createCourseReview(@RequestBody CourseReviewRespDto courseReviewDTO) {
        return courseReviewService.createCourseReview(courseReviewDTO);
    }

}
