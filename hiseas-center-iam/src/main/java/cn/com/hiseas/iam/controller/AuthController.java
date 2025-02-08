package cn.com.hiseas.iam.controller;

import cn.com.hiseas.iam.dto.LoginDTO;
import cn.com.hiseas.iam.service.AuthService;
import cn.dev33.satoken.util.SaResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public SaResult login(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

}
