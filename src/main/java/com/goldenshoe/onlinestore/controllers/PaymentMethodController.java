package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.PaymentMethodResponse;
import com.goldenshoe.onlinestore.services.PaymentMethodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
@RestController
@RequestMapping("api/v1/paymentMethods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all payment methods.")
    public List<PaymentMethodResponse> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }
}
