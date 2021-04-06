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
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;//当前下标
        int next;//下次下标
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483547 ? 0 : current + 1;
        //自旋锁
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next" + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //服务器集群总数量
        int size = serviceInstances.size();
        //接口第几次请求数
        int index = getAndIncrement() % size;
        return serviceInstances.get(index);
    }
}
