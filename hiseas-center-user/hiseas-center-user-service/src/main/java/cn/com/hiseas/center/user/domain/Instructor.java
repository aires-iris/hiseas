package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName instructor
 */
@TableName(value = "instructor")
@Data
public class Instructor implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer instructorId;

    /**
     *
     */
    private String instructorName;

    /**
     *
     */
    private String position;

    /**
     *
     */
    private Integer sortOrder;

    /**
     *
     */
    private String bio;

    /**
     *
     */
    private Date createdAt;

    /**
     *
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}