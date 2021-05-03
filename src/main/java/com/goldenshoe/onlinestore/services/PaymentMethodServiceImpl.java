package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.PaymentMethodResponse;
import com.goldenshoe.onlinestore.mappers.PaymentMethodMapper;
import com.goldenshoe.onlinestore.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 01/05/2021
 */
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper paymentMethodMapper;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository, PaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentMethodMapper = paymentMethodMapper;
    }

    @Override
    public List<PaymentMethodResponse> getAllPaymentMethods() {
        return paymentMethodRepository.findAll()
                .stream()
                .map(paymentMethodMapper::toPaymentMethodResponse)
                .collect(Collectors.toList());
    }
}
