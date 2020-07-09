package com.yu.springcloud.controller;

import com.yu.springcloud.domain.CommonResult;
import com.yu.springcloud.domain.Order;
import com.yu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public CommonResult createOrder(Order order){
        order.setStatus(0);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
