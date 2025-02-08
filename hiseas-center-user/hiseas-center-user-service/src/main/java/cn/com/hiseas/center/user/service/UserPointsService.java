package cn.com.hiseas.center.user.service;

import cn.com.hiseas.center.user.dto.response.UserPointsRespDto;
import cn.com.hiseas.center.user.domain.UserPoints;
import com.baomidou.mybatisplus.extension.service.IService;


public interface UserPointsService extends IService<UserPoints> {

    void accumulate(UserPointsRespDto userPointsRespDto);
}
