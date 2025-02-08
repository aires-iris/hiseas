package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user_roles
 */
@TableName(value = "user_roles")
@Data
public class UserRole implements Serializable {
    private Long userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}