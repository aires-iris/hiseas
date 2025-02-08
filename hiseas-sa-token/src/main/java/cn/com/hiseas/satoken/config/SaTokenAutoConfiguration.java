package cn.com.hiseas.satoken.config;

import cn.com.hiseas.satoken.YamlPropertySourceFactory;
import cn.com.hiseas.satoken.handler.SaTokenExceptionHandler;
import cn.com.hiseas.satoken.service.StpInterfaceImpl;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * saToken SpringBoot 自动配置类
 *
 * @author zhengxiang
 * @since 0.0.1
 */
@AutoConfiguration
@PropertySource(value = "classpath:sa-token-config.yml", factory = YamlPropertySourceFactory.class)
public class SaTokenAutoConfiguration implements WebMvcConfigurer {

    /**
     * 注入 StpInterface接口 实现类，完成角色-权限，用户-角色 的查询
     */
    @Bean
    public StpInterface stpInterface() {
        return new StpInterfaceImpl();
    }

    /**
     * 注入 SaTokenJwt 配置类
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

    /**
     * 注入 SaTokenExceptionHandler 异常处理器
     */
    @Bean
    public SaTokenExceptionHandler saTokenExceptionHandler() {
        return new SaTokenExceptionHandler();
    }

    /**
     * 添加 Sa-Token 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> SaRouter
                .match("/**")
                .notMatch(getExcludePaths())
                .check(r -> StpUtil.checkLogin()))).addPathPatterns("/**");
    }

    private List<String> getExcludePaths() {
        return List.of("/api/auth/login", "/api/users/login");
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
