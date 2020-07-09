package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    private static final  String url="http://cloud-payment-service";

    @RequestMapping("/zk")
    public  String order(){
        return restTemplate.getForObject(url+"/provider/payment/zk",String.class);
    }
}
