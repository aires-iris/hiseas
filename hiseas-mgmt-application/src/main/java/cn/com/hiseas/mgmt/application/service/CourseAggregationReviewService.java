package cn.com.hiseas.mgmt.application.service;

import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Architecture Station
 * @version 1.0
 */
public interface CourseAggregationReviewService {

    // 添加课程评论
    ResponseEntity<?> createCourseReview(CourseReviewRespDto courseReviewDTO);

}
