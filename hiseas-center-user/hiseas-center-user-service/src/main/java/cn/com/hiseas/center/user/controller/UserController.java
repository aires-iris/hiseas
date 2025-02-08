package cn.com.hiseas.center.user.controller;

/**
 * @author zhengxiang
 * @version 1.0
 */

import cn.com.hiseas.center.user.api.IUserApi;
import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.com.hiseas.center.user.service.UserService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements IUserApi {

    @Resource
    private final UserService userService;


    @PostMapping("/login")
    public SaResult login(@RequestBody UserRespDto userRespDto) {
        return userService.validateUser(userRespDto);
    }

    // 通过ID查询用户信息
    @SaCheckPermission("user:query")
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok().build();
    }


}
