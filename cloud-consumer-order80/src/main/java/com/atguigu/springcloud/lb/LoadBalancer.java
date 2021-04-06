package com.atguigu.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @author xiguozh
 * @version 1.0
 * @description
 * @date 2021-04-06 17-00
 * @since 1.8
 */
public interface LoadBalancer {

    /**
     * 收集服务实例
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
