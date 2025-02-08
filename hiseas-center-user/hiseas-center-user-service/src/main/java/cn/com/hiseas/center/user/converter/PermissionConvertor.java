package cn.com.hiseas.center.user.converter;

import cn.com.hiseas.center.user.dto.response.PermissionRespDto;
import cn.com.hiseas.center.user.domain.Permission;
import org.mapstruct.Mapper;

/**
 * @author zhengxiang
 * @version 1.0

 */
@Mapper(componentModel = "spring")
public interface PermissionConvertor {
    PermissionRespDto toDTO(Permission permission);
    Permission toDO(PermissionRespDto permissionRespDto);
}
