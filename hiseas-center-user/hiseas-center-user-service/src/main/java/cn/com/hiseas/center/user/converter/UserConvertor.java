package cn.com.hiseas.center.user.converter;

import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.com.hiseas.center.user.domain.User;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserConvertor {
    UserRespDto toDTO(User user);

    User toDO(UserRespDto userRespDto);
}
