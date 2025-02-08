package cn.com.hiseas.center.user.converter;

import cn.com.hiseas.center.user.dto.response.InstructorRespDto;
import cn.com.hiseas.center.user.domain.Instructor;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface InstructorConverter {
    InstructorRespDto toDTO(Instructor instructor);

    Instructor toDO(InstructorRespDto instructorRespDto);
}