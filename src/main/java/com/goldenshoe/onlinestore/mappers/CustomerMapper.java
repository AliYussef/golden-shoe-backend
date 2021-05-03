package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.CustomerResponse;
import com.goldenshoe.onlinestore.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponse toCustomerResponse(Customer customer);
}
