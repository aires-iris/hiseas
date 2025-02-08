package cn.com.hiseas.mgmt.application.converter;

import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.user.dto.response.InstructorRespDto;
import cn.com.hiseas.mgmt.application.vo.CourseDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Architecture Station
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CourseDetailConverter {

    /**
     * 在每个DTO中都有一个讲师ID，所以需要指定将哪个DTO中的讲师ID赋值给CourseDetailVO中的讲师ID
     *
     * @param courseDTO
     * @param instructorDTO
     * @return
     */

    @Mapping(source = "instructorDTO.instructorId", target = "instructorId")
    @Mapping(source = "courseDTO.createdAt", target = "createdAt")
    @Mapping(source = "courseDTO.updatedAt", target = "updatedAt")
    CourseDetailVO toCourseDetailVO(CourseRespDto courseDTO, InstructorRespDto instructorDTO);

}