package cn.com.hiseas.center.course.dto.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程实体DTO
 *
 * @author zhengxiang
 * @date 2025/1/16 01:19
 * @since 0.0.1
 */
@Data
public class CourseRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long courseId;

    private String courseName;

    private BigDecimal price;

    private BigDecimal actualPrice;

    private Long instructorId;

    private Integer purchaseCount;

    private Integer duration;

    private String description;

    private Integer learnerCount;

    private Integer favoriteCount;

    private Date createdAt;

    private Date updatedAt;

}
