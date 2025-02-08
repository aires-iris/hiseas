package cn.com.hiseas.center.user.controller;

import cn.com.hiseas.center.user.api.IInstructorApi;
import cn.com.hiseas.center.user.dto.response.InstructorRespDto;
import cn.com.hiseas.center.user.converter.InstructorConverter;
import cn.com.hiseas.center.user.domain.Instructor;
import cn.com.hiseas.center.user.service.InstructorService;
import cn.dev33.satoken.annotation.SaIgnore;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/instructors")
public class InstructorController implements IInstructorApi {

    private final InstructorService instructorService;
    private final InstructorConverter instructorConverter;

    @Override
    @GetMapping("/{instructorId}")
    @SaIgnore
    public ResponseEntity<InstructorRespDto> getInstructorById(@PathVariable Long instructorId) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        log.info("user服务 token: {}", token);
        Instructor instructor = instructorService.getById(instructorId);
        if (instructor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(instructorConverter.toDTO(instructor));
    }
}