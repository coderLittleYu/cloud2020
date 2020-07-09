package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/order")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> paymentCommonResult=new CommonResult<>();
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public String getStringById(){
        //openfeign ribbon 默认等待时间为一秒钟  超时报错
        return paymentService.getStringId();
    }
}
