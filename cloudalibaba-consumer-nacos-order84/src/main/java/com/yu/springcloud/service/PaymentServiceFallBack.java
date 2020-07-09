package com.yu.springcloud.service;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallBack implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
