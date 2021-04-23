package com.atguigu.springcloud.filter;

import cn.hutool.core.util.StrUtil;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-22 19-32
 * @since 1.8
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************come in MyLogGateWayFilter: " + new Date());
        // 校验是否有uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (StrUtil.isEmpty(uname)) {
            log.info("******用户名为空，非法用户，/(ㄒoㄒ)/~~");
            // 返回失败原因
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 自定义过滤器，过滤通过后程序继续执行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 数字越小优先级越高，0最高
        return 0;
    }
}
