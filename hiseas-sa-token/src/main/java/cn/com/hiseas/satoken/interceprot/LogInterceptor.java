package cn.com.hiseas.satoken.interceprot;

import cn.com.hiseas.satoken.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * desc
 *
 * @author zhengxiang
 * @date 2025/1/19 20:11
 * @since 0.0.1
 */
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(Constants.TRACE_ID);
        if (!StringUtils.hasLength(traceId)) {
            traceId = generateTraceId();
        }
        MDC.put(Constants.TRACE_ID, traceId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.remove(Constants.TRACE_ID);
    }
}
