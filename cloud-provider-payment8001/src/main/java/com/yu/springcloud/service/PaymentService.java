package com.yu.springcloud.service;

import com.yu.springcloud.entities.Payment;

public interface PaymentService {

    int insert(Payment payment);

    Payment getPaymentById(Long id);
}
