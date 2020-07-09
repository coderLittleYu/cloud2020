package com.yu.springcloud.service;

import com.yu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {

    void create(Order order);

    void updateStatus(Long id,int status);
}
