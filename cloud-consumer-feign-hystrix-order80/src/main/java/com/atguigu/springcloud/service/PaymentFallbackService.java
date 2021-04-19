package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-19 10-10
 * @since 1.8
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_Ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
