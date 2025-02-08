package cn.com.hiseas.center.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName course_review
 */
@TableName(value = "course_review")
@Data
public class CourseReview implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer reviewId;

    private Integer courseId;

    private Integer userId;

    private Integer rating;

    private String comment;

    private Date createdAt;

    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
