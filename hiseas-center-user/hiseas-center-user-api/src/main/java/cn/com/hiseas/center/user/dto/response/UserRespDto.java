package cn.com.hiseas.center.user.dto.response;

import lombok.Data;

import java.util.Date;

/**
 * @author zhengxiang
 * @version 1.0
 
 */
@Data
public class UserRespDto {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String phoneNumber;

    private Integer isActive;

    private Date createdAt;

    private Date updatedAt;

}
