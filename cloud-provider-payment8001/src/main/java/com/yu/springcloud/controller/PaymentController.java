package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/provider/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        log.info(port);
        int result=paymentService.insert(payment);
        log.info("*************插入结果："+result);
        if (result>0){
            return new CommonResult(200,"端口："+port+",插入数据库成功",result);
        }else{
            return  new CommonResult(444,"端口："+port+",插入数据库失败",null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult(200,"查询成功,serverPort:"+port,payment);
        }else{
            return new CommonResult(444,"端口："+port+",没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping(value = "/timeout")
    public String getString()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  port;


    }


}
