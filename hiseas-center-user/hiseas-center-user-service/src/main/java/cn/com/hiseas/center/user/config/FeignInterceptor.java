package cn.com.hiseas.center.user.config;

import cn.com.hiseas.common.constant.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取当前线程的traceId
        String traceId = MDC.get(Constants.TRACE_ID);
        
        // 如果traceId不为空，添加到请求头中
        if (traceId != null && !traceId.isEmpty()) {
            requestTemplate.header(Constants.TRACE_ID, traceId);
        }
    }
}
