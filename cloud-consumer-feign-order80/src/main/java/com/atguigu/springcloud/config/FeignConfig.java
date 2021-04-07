package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiguozh
 * @version 1.0
 * @description 日志等级设置
 * @date 2021-04-07 16-58
 * @since 1.8
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
//    NONE：默认的 不显示任何日志
//    BASIC：仅记录请求方法、URL、响应状态码及执行时间
//    HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息
//    FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
}
