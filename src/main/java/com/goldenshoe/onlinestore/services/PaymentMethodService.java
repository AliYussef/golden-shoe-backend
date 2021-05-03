package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.PaymentMethodResponse;

import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
public interface PaymentMethodService {
    List<PaymentMethodResponse> getAllPaymentMethods();
}
