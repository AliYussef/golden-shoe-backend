package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by aliyussef on 28/04/2021
 */
@Data
@ApiModel(description = "Order request body")
public class OrderRequest {
    @NotNull(message = "Cannot process the order without products")
    @NotEmpty
    private List<OrderDetailRequest> orderDetailsRequest;
    private Long voucherId;
    @Valid
    @NotNull(message = "Payment method cannot be null")
    private PaymentMethodRequest paymentMethod;
    @Valid
    @NotNull(message = "Customer cannot be null")
    private CustomerRequest customer;
    @Valid
    @NotNull(message = "Billing address cannot be null")
    private AddressRequest billingAddress;
    @Valid
    @NotNull(message = "Shipping address cannot be null")
    private AddressRequest shippingAddress;
    @Valid
    @NotNull(message = "Shipper cannot be null")
    private ShipperRequest shipper;
}
