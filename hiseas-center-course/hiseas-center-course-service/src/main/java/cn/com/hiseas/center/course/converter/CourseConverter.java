package cn.com.hiseas.center.course.converter;

import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.course.entity.Course;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CourseConverter {

    CourseRespDto toDTO(Course course);

    Course toDO(CourseRespDto courseDTO);

}