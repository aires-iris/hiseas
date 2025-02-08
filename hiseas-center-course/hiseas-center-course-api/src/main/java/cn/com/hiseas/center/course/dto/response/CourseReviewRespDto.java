package cn.com.hiseas.center.course.dto.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程评论DTO
 *
 * @author zhengxiang
 * @date 2025/1/16 01:20
 * @since 0.0.1
 */
@Data
public class CourseReviewRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer reviewId;

    private Integer courseId;

    private Integer userId;

    private Integer rating;

    private String comment;

    private Date createdAt;

    private Date updatedAt;

}
