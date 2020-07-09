package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.myLB.MyLoadB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/consumer/order")
public class OrderController {

    public  static  final  String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    public  String url="http://localhost:8001";


    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;


    @Autowired
    private MyLoadB myLoadB;

    @GetMapping("/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> get(@PathVariable Long id){
        //调用其它服务
        return  restTemplate.getForObject(PAYMENT_URL+"/provider/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_URL +"/provider/payment/create",payment,CommonResult.class);
    }

    /**
     * 自定义负载均衡算法测试
     * @return
     */
    @GetMapping("/myLbTest/{id}")
    @ResponseBody
    public  CommonResult<Payment> myLbTest(@PathVariable Long id){
        //获取当前所有注册的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null || instances.size()==0){
            return null;
        }
        ServiceInstance serviceInstance = myLoadB.chooseServer(instances);
        URI url=serviceInstance.getUri();
        return restTemplate.getForObject(url+"/provider/payment/get/"+id,CommonResult.class);
    }


}
