package com.gtguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

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
     *
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
}
