package cn.com.hiseas.center.course.service.impl;

import cn.com.hiseas.center.course.converter.CourseReviewConverter;
import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.center.course.entity.CourseReview;
import cn.com.hiseas.center.course.mapper.CourseReviewMapper;
import cn.com.hiseas.center.course.service.CourseReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CourseReviewServiceImpl extends ServiceImpl<CourseReviewMapper, CourseReview> implements CourseReviewService {

    @Resource
    private CourseReviewMapper courseReviewMapper;

    @Resource
    private CourseReviewConverter courseReviewConverter;
    @Override
    public boolean save(CourseReview entity) {
        return super.save(entity);
    }


    @Override
    public HttpStatusCode createCourseReview(CourseReviewRespDto courseReviewReqDto) {
        courseReviewMapper.insert(courseReviewConverter.toDO(courseReviewReqDto));
        return HttpStatus.OK;
    }
}




