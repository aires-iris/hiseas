package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName role_permissions
 */
@TableName(value = "role_permissions")
@Data
public class RolePermission implements Serializable {
    private Integer roleId;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;
}