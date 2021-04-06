package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-06 11-22
 * @since 1.8
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // Ribbon 定义为随机
        return new RandomRule();
    }
}
