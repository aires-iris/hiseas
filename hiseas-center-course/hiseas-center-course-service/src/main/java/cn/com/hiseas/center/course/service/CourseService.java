package cn.com.hiseas.center.course.service;

import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.course.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

/**
 * @author kiki
 * @description 针对表【course】的数据库操作Service
 * @createDate 2024-10-02 15:03:33
 */
public interface CourseService extends IService<Course> {

    ResponseEntity<CourseRespDto> getCourse(Long courseId);

}
