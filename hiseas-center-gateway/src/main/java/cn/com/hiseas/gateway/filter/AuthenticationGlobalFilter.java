package cn.com.hiseas.gateway.filter;

import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class AuthenticationGlobalFilter implements GlobalFilter {

    private static final String LOGIN_URL = "api/auth/login";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 解决saTokenContextException: 无法获取到上下文
        SaReactorSyncHolder.setContext(exchange);
        // 登录接口放行
        if (exchange.getRequest().getURI().getPath().contains(LOGIN_URL)) {
            return chain.filter(exchange);
        }
        // 检查是否登录
        if (!StpUtil.isLogin()) {
            return BuildErrorResponse(exchange, "用户未登录");
        }
        // 在此处添加其他验证 比如权限,流控,ip黑白名单
        // 如果已经登录,放行
        return chain.filter(exchange);
    }

    private Mono<Void> BuildErrorResponse(ServerWebExchange exchange, String message) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        String errMsg = String.format("{\"code\":500,\"msg\":%s}", message);
        byte[] bytes = errMsg.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        return response.writeWith(Flux.just(buffer));
    }
}
