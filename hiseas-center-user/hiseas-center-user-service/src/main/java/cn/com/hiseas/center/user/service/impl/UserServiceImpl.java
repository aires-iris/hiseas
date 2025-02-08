package cn.com.hiseas.center.user.service.impl;

import cn.com.hiseas.center.user.dto.response.UserRespDto;
import cn.com.hiseas.center.user.converter.UserConvertor;
import cn.com.hiseas.center.user.domain.User;
import cn.com.hiseas.center.user.mapper.UserMapper;
import cn.com.hiseas.center.user.service.UserService;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final UserConvertor userConvertor;


    @Override
    public SaResult validateUser(UserRespDto userRespDto) {
        if (!StringUtils.hasText(userRespDto.getUsername())) {
            return SaResult.error("用户名不允许为空");
        }

        if (!StringUtils.hasText(userRespDto.getPassword())) {
            return SaResult.error("密码不允许为空");
        }

        User user = userMapper.getUserByUsername(userRespDto.getUsername());

        if (user == null) {
            return SaResult.error("用户不存在");
        }

        if (!user.getPassword().equals(userRespDto.getPassword())) {  // 注意：实际应用中应使用加密比较
            return SaResult.error("用户名/密码错误");
        }

        if (Optional.ofNullable(user.getIsActive()).orElse(0) != 1) {
            return SaResult.error("用户未激活");
        }

        UserRespDto validatedUserRespDto = userConvertor.toDTO(user);

        // 如果所有检查都通过，则登录成功
        return SaResult.ok("登录成功").setData(validatedUserRespDto);
    }


    @Override
    public ResponseEntity<?> createUser(UserRespDto userRespDto) {
        User user = userConvertor.toDO(userRespDto);
        boolean success = save(user);
        return success ? ResponseEntity.status(HttpStatus.CREATED).body("User created successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User creation failed");
    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        User user = getById(id);
        UserRespDto userRespDto = userConvertor.toDTO(user);
        return user != null ? ResponseEntity.ok(userRespDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @Override
    public ResponseEntity<List<UserRespDto>> getAllUsers() {
        List<UserRespDto> users = list().stream().map(userConvertor::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<?> updateUser(Long id, UserRespDto userRespDto) {
        User user = userConvertor.toDO(userRespDto);
        user.setId(id);
        boolean success = updateById(user);
        return success ? ResponseEntity.ok("User updated successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User update failed");
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        boolean success = removeById(id);
        return success ? ResponseEntity.ok("User deleted successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User deletion failed");
    }
}




