package cn.com.hiseas.center.course.converter;

import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.center.course.entity.CourseReview;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CourseReviewConverter {

    CourseReviewRespDto toDTO(CourseReview courseReview);

    CourseReview toDO(CourseReviewRespDto courseReviewDTO);

}
