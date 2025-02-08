package cn.com.hiseas.mgmt.application.controller;

import cn.com.hiseas.center.course.api.ICourseApi;
import cn.com.hiseas.center.course.dto.response.CourseRespDto;
import cn.com.hiseas.center.user.api.IInstructorApi;
import cn.com.hiseas.center.user.dto.response.InstructorRespDto;
import cn.com.hiseas.mgmt.application.converter.CourseDetailConverter;
import cn.com.hiseas.mgmt.application.vo.CourseDetailVO;
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Architecture Station
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseAggregationController {

    private final CourseDetailConverter courseDetailConverter;
    private final IInstructorApi instructorApi;
    private final ICourseApi courseApi;

    @SaIgnore
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDetailVO> getCourseDetail(@PathVariable Long courseId) {
        // 调用课程服务获取课程信息
        ResponseEntity<CourseRespDto> course = courseApi.getCourse(courseId);
        // 判断课程信息是否为空
        if (!course.getStatusCode().is2xxSuccessful() || course.getBody() == null) {
            return ResponseEntity.notFound().build();
        }
        CourseRespDto courseDTO = course.getBody();
        // 调用用户服务获取讲师信息
        ResponseEntity<InstructorRespDto> instructorResponseEntity = instructorApi.getInstructorById(courseDTO.getInstructorId());
        InstructorRespDto instructorDTO = null;
        if (instructorResponseEntity.getStatusCode().is2xxSuccessful() && instructorResponseEntity.getBody() != null) {
            instructorDTO = instructorResponseEntity.getBody();
        } else {
            log.error("获取讲师信息失败,失败的讲师ID：{}", courseDTO.getInstructorId());
        }
        return ResponseEntity.ok(courseDetailConverter.toCourseDetailVO(courseDTO, instructorDTO));
    }

}