package cn.com.hiseas.center.course.rest;

import cn.com.hiseas.center.course.api.ICourseApi;
import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.course.service.CourseService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengxiang
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/course")
public class CourseController implements ICourseApi {

    @Resource
    private CourseService courseService;

    @Override
    public ResponseEntity<CourseRespDto> getCourse(Long courseId) {
        log.info("getCourse courseId:{}", JSONObject.toJSONString(courseId, SerializerFeature.PrettyFormat));
        return courseService.getCourse(courseId);
    }
}