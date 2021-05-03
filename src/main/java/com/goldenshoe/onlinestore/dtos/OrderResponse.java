package com.goldenshoe.onlinestore.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goldenshoe.onlinestore.models.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by aliyussef on 28/04/2021
 */
@Data
@ApiModel(description = "Order response body")
public class OrderResponse {
    private Long id;
    private double totalAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate expectedDeliveryDate;
    private PaymentMethodResponse paymentMethod;
    private Set<OrderDetailResponse> orderDetail;
    private CustomerResponse customer;
    private AddressResponse billingAddress;
    private AddressResponse shippingAddress;
    private ShipperResponse shipper;
    private VoucherResponse voucher;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private ShippingStatus shippingStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdAt;
}
