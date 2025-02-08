package cn.com.hiseas.center.course.service.impl;

import cn.com.hiseas.center.course.converter.CourseConverter;
import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.course.entity.Course;
import cn.com.hiseas.center.course.mapper.CourseMapper;
import cn.com.hiseas.center.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kiki
 * @description 针对表【course】的数据库操作Service实现
 * @createDate 2024-10-02 15:03:33
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    private CourseConverter courseConverter;
    @Override
    public ResponseEntity<CourseRespDto> getCourse(Long courseId) {
        Course course = getById(courseId);
        return new ResponseEntity<>(courseConverter.toDTO(course), HttpStatus.OK);
    }
}




