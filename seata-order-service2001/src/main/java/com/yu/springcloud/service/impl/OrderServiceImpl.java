package com.yu.springcloud.service.impl;

import com.yu.springcloud.dao.OrderDao;
import com.yu.springcloud.domain.Order;
import com.yu.springcloud.service.AccountService;
import com.yu.springcloud.service.OrderService;
import com.yu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;




    @Override
    @GlobalTransactional
    public void  create(Order order) {
         log.info("插入订单数据数据");
         orderDao.insert(order);
         log.info("修改库存");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("余额扣除");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("*********************下单完成！");
        log.info("修改订单状态");
        orderDao.updateStatus(order.getId(),1);

    }

    @Override
    public void updateStatus(Long id, int status) {
        orderDao.updateStatus(id,status);
    }
}
