package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumerMain83.class,args);
    }
}
