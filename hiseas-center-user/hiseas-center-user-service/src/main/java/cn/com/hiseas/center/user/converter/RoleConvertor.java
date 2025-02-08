package cn.com.hiseas.center.user.converter;

import cn.com.hiseas.center.user.dto.response.RoleRespDto;
import cn.com.hiseas.center.user.domain.Role;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface RoleConvertor {
    RoleRespDto toDTO(Role role);

    Role toDO(RoleRespDto roleRespDto);
}
