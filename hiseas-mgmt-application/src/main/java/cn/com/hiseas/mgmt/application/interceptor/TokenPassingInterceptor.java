package cn.com.hiseas.mgmt.application.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 令牌传递的拦截器
 *
 * @author Architecture Station
 * @version 1.0
 */
@Component
public class TokenPassingInterceptor implements RequestInterceptor {

    private static final String HEADER_NAME = "Access-Token";

    /**
     * 将原有请求中的令牌取出，并添加到新的请求中
     *
     * @param requestTemplate 新请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获得原有的请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // 令牌传递
        HttpServletRequest request = requestAttributes.getRequest();
        String accessToken = request.getHeader(HEADER_NAME);
        if (StringUtils.hasLength(accessToken)) {
            requestTemplate.header(HEADER_NAME, accessToken);
        }
    }
}
