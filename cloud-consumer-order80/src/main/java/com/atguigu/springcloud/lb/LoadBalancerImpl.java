package com.atguigu.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-06 17-02
 * @since 1.8
 */
@Component
public class LoadBalancerImpl implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return null;
    }
}
