package cn.com.hiseas.iam.service;

import cn.com.hiseas.iam.dto.LoginDTO;
import cn.dev33.satoken.util.SaResult;

/**
 * @author zhengxiang
 * @version 1.0
 */
public interface AuthService {
    SaResult login(LoginDTO loginDTO);
}
