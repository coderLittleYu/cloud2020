package com.yu.springcloud.myLB;

import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义的负载均衡算法
 */
public interface MyLoadB {

    ServiceInstance chooseServer(List<ServiceInstance> instances);

}
