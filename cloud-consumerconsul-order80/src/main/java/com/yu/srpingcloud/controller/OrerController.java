package com.yu.srpingcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrerController {

    private static  final  String URL="http://consul-provider-payment";

    @Resource
    public RestTemplate restTemplate;


    @GetMapping("/consul")
    public String getPayment(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}
