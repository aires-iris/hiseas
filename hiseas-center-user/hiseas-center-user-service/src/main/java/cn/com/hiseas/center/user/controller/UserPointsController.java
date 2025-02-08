package cn.com.hiseas.center.user.controller;

import cn.com.hiseas.center.user.api.IUserPointsApi;
import cn.com.hiseas.center.user.dto.response.UserPointsRespDto;
import cn.com.hiseas.center.user.service.UserPointsService;
import com.alibaba.fastjson2.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengxiang
 * @version 1.0
 
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userScore")
@Slf4j
public class UserPointsController implements IUserPointsApi {

    private final UserPointsService userPointsService;

    // 用户积累累加1
    @PutMapping
    public ResponseEntity<Void> accumulateUserPoints(@RequestBody UserPointsRespDto userPointsRespDto) {
        log.info("用户增加积分:{}", JSONObject.toJSONString(userPointsRespDto));
        userPointsService.accumulate(userPointsRespDto);
        log.info("用户增加积分成功:{}", JSONObject.toJSONString(userPointsRespDto));
        return ResponseEntity.ok().build();
    }

}
