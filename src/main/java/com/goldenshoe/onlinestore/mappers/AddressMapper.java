package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.AddressResponse;
import com.goldenshoe.onlinestore.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressResponse toAddressResponse(Address address);
}
