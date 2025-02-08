package cn.com.hiseas.center.user.dto.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class InstructorRespDto implements Serializable {
    private Long instructorId;

    private String instructorName;

    private String position;

    private Integer sortOrder;

    private String bio;

    private Date createdAt;

    private Date updatedAt;

    @Serial
    private static final long serialVersionUID = 1L;
}
