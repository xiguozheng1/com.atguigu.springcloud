package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-01 09-09
 * @since 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
/**该注解用于向使用consul或者zookeeper作为注册中心时注册服务**/
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
