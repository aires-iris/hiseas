package cn.com.hiseas.mgmt.application.service.impl;

import cn.com.hiseas.center.course.api.ICourseReviewApi;
import cn.com.hiseas.center.course.dto.response.CourseReviewRespDto;
import cn.com.hiseas.center.user.api.IUserPointsApi;
import cn.com.hiseas.center.user.dto.response.UserPointsRespDto;
import cn.com.hiseas.mgmt.application.service.CourseAggregationReviewService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Architecture Station
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseReviewServiceImpl implements CourseAggregationReviewService {

    private final ICourseReviewApi courseReviewApi;
    private final IUserPointsApi userPointsApi;


    @Override
    @GlobalTransactional
    public ResponseEntity<?> createCourseReview(CourseReviewRespDto courseReviewDTO) {
        try {
            log.info("Creating course review for user: {}", courseReviewDTO.getUserId());
            courseReviewApi.createCourseReview(courseReviewDTO);
            UserPointsRespDto userPointsDTO = new UserPointsRespDto();
            userPointsDTO.setUserId(courseReviewDTO.getUserId());
            userPointsDTO.setPoints(5);
            log.info("Accumulating user points for user: {}", userPointsDTO.getUserId());
            userPointsApi.accumulateUserPoints(userPointsDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Failed to create course review or accumulate user points", e);
            // TM需要将异常继续抛出,否则GlobalTransactional感知不到异常产生,依然会进行分支事务的提交
            throw new RuntimeException("Failed to create course review or accumulate user points");
        }
    }
}









