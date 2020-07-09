package com.yu.springcloud.controller;

import com.yu.springcloud.domain.CommonResult;
import com.yu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController  {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") int count){
        storageService.decrease(productId,count);
        return  new CommonResult(200,"库存减扣成功！");
    }


}
