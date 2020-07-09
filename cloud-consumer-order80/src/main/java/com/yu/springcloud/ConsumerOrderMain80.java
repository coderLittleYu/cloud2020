package com.yu.springcloud;

import com.yu.myrule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = Myrule.class)
public class ConsumerOrderMain80 {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerOrderMain80.class,args);
    }
}
