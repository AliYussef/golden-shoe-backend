package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.PaymentMethodResponse;
import com.goldenshoe.onlinestore.models.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface PaymentMethodMapper {
    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethodResponse toPaymentMethodResponse(PaymentMethod paymentMethod);
}
