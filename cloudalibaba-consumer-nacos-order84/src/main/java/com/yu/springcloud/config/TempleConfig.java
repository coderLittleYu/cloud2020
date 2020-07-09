package com.yu.springcloud.config;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TempleConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }


}
