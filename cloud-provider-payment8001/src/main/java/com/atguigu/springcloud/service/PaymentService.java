package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-03-26 11-12
 * @since 1.8
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
