package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/consul")
    public  String getPayment(){
        return "springcloud with consul:"+port+"\t"+ UUID.randomUUID();
    }
}
