package cn.com.hiseas.center.user.service.impl;

import cn.com.hiseas.center.user.dto.response.UserPointsRespDto;
import cn.com.hiseas.center.user.domain.UserPoints;
import cn.com.hiseas.center.user.mapper.UserPointsMapper;
import cn.com.hiseas.center.user.service.UserPointsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserPointsServiceImpl extends ServiceImpl<UserPointsMapper, UserPoints> implements UserPointsService {

    @Resource
    private UserPointsMapper userPointsMapper;

    @Override
    public void accumulate(UserPointsRespDto userPointsRespDto) {
        UserPoints userPoints = userPointsMapper.getUserPointsByUserId(userPointsRespDto.getUserId());
        if (userPoints == null) {
            userPoints = new UserPoints();
            userPoints.setUserId(userPointsRespDto.getUserId());
            userPoints.setPoints(userPointsRespDto.getPoints());
            userPoints.setCreatedAt(new Date());
            userPoints.setUpdatedAt(new Date());
            userPointsMapper.insert(userPoints);
        } else {
            userPoints.setPoints(userPoints.getPoints() + userPointsRespDto.getPoints() * 2);
            userPoints.setUpdatedAt(new Date());
            userPointsMapper.updateById(userPoints);
        }
    }
}




