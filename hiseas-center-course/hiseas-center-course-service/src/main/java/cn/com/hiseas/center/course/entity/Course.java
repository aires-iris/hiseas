package cn.com.hiseas.center.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName course
 */
@TableName(value = "course")
@Data
public class Course implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer courseId;

    /**
     *
     */
    private String courseName;

    /**
     *
     */
    private BigDecimal price;

    /**
     *
     */
    private BigDecimal actualPrice;

    /**
     *
     */
    private Integer instructorId;

    /**
     *
     */
    private Integer purchaseCount;

    /**
     *
     */
    private Integer duration;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private Integer learnerCount;

    /**
     *
     */
    private Integer favoriteCount;

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