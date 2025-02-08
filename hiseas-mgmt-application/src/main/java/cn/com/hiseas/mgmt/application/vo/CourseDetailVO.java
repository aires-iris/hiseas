package cn.com.hiseas.mgmt.application.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Architecture Station
 * @version 1.0
 */
@Data
public class CourseDetailVO {
    private Integer courseId;

    private String courseName;

    private BigDecimal price;

    private BigDecimal actualPrice;

    private Integer purchaseCount;

    private Integer duration;

    private String description;

    private Integer learnerCount;

    private Integer favoriteCount;

    private Date createdAt;

    private Date updatedAt;

    private Integer instructorId;

    private String instructorName;

    private String position;

    private String bio;

}