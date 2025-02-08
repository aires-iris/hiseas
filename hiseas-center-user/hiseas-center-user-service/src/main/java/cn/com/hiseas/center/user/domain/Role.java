package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName roles
 */
@Data
@TableName(value = "roles")
public class Role implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private String description;

    private static final long serialVersionUID = 34656L;
}
