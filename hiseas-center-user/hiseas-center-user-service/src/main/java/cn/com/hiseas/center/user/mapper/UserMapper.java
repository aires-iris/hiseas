package cn.com.hiseas.center.user.mapper;

import cn.com.hiseas.center.user.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity com.sa.user.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM users WHERE username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User validateUser(@Param("username") String username, @Param("password") String password);

}




