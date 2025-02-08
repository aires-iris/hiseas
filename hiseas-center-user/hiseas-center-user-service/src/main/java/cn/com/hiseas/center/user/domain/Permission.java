package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName permissions
 */
@TableName(value = "permissions")
@Data
public class Permission implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private static final long serialVersionUID = 1L;
}