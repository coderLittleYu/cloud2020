package com.yu.springcloud.service.impl;

import com.yu.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * 订单模块统一的服务降级消息处理
 */
@Component
public class OrderHystrixFallbackService implements OrderHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "***********服务异常*******"+"\t"+"paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "***********服务异常*******"+"\t"+"paymentInfo_TimeOut";
    }
}
