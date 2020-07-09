package com.yu.springcloud.myLB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements MyLoadB {

    private AtomicInteger atomicInteger=new AtomicInteger(0);


    public  final int getAtomic(){
        int current;
        int next;
        do{
            current=atomicInteger.get();
            next=current>=Integer.MAX_VALUE?0:current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.printf("**********第几次访问："+next);
        return next;
    }

    //负载均衡算法：rest接口第几次请求数 % 服务器总集群数=实际调用服务器集群下标
    //每次服务器重启后rest接口计数从1开始
    @Override
    public ServiceInstance chooseServer(List<ServiceInstance> instances) {

        int index=getAtomic() % instances.size();
        return instances.get(index);
    }
}
