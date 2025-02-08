package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName users
 */
@TableName(value = "users")
@Data
public class User implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String phoneNumber;

    private Integer isActive;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}
