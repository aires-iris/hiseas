package cn.com.hiseas.center.user.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName users
 */
@Data
public class UsersRespDto implements Serializable {
    private Integer userId;
    private String username;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private static final long serialVersionUID = 1L;
}
