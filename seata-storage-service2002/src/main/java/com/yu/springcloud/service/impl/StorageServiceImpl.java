package com.yu.springcloud.service.impl;

import com.yu.springcloud.dao.StorageDto;
import com.yu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDto storageDto;

    @Override
    public void decrease(Long productId, int count) {
        //模拟事物控制
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        storageDto.decrease(productId,count);
    }
}
