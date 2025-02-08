package cn.com.hiseas.center.user.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName user_points
 */
@Data
public class UserPointsRespDto implements Serializable {
    private Integer userPointsId;
    private Integer userId;
    private Integer points;
    private Date createdAt;
    private Date updatedAt;
    private static final long serialVersionUID = 1L;
}
