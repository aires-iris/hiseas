package cn.com.hiseas.center.user.mapper;

import cn.com.hiseas.center.user.domain.UserPoints;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity com.sa.user.domain.UserPoints
 */
@Mapper
public interface UserPointsMapper extends BaseMapper<UserPoints> {

    // 通过user_id查询用户积分
    @Select("SELECT * FROM user_points WHERE user_id = #{userId}")
    UserPoints getUserPointsByUserId(Integer userId);

}




