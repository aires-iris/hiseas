package cn.com.hiseas.common.config;

import cn.com.hiseas.common.constant.Constants;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

/**
 * desc
 *
 * @author zhengxiang
 * @date 2025/1/19 21:58
 * @since 0.0.1
 */
@Slf4j
public class MdcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        try {
            String traceId = httpServletRequest.getHeader(Constants.TRACE_ID);
            if (!StringUtils.hasLength(traceId)) {
                traceId = UUID.randomUUID().toString();
            }
            MDC.put(Constants.TRACE_ID, traceId);
            MDC.put(Constants.TS, String.valueOf(System.currentTimeMillis()));
            log.info("{}", httpServletRequest.getRequestURI() + " call received!");
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }
}
