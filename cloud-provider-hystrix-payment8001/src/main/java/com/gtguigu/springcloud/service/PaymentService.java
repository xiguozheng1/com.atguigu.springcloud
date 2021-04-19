package com.gtguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-13 19-33
 * @since 1.8
 */
@Service
public class PaymentService {
    /**
     * 正产访问 肯定OK
     * 服务降级
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Ok, id:" + id + "\t" + "***肯定成功***";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int age = 10 / 0;
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池" + Thread.currentThread().getName() + "id:" + id + "\t" + "O(∩_∩)O哈哈~"+" ***耗时(秒)***";
    }
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "系统繁忙或者运行报错，请稍后再试，id: " + id + "\t" + " (꒦_꒦)*****";
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期(又叫时间范围)
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),})// 失败率达到多少后跳闸
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();//和UUID.randomUUID().toString()一样
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
