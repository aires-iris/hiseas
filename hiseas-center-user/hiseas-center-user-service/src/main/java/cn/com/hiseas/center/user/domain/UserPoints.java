package cn.com.hiseas.center.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName user_points
 */
@TableName(value = "user_points")
@Data
public class UserPoints implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer userPointsId;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private Integer points;

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