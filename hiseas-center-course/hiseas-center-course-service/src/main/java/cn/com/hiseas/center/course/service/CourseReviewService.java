package cn.com.hiseas.center.course.service;

import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.center.course.entity.CourseReview;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.HttpStatusCode;

public interface CourseReviewService extends IService<CourseReview> {

    HttpStatusCode createCourseReview(CourseReviewRespDto courseReviewReqDto);
}
