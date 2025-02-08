package cn.com.hiseas.iam.config;

import cn.com.hiseas.common.config.MdcFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengxiang
 * @version 1.0
 */
@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<MdcFilter> logFilter() {
        FilterRegistrationBean<MdcFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new MdcFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}