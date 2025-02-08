package cn.com.hiseas.center.user.service;

import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.com.hiseas.center.user.domain.User;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService extends IService<User> {

    SaResult validateUser(UserRespDto userRespDto);

    ResponseEntity<?> createUser(UserRespDto userRespDto);

    ResponseEntity<?> getUserById(Long id);

    ResponseEntity<List<UserRespDto>> getAllUsers();

    ResponseEntity<?> updateUser(Long id, UserRespDto userRespDto);

    ResponseEntity<?> deleteUser(Long id);
}
