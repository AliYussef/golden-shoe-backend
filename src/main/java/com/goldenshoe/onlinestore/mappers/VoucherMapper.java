package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.VoucherResponse;
import com.goldenshoe.onlinestore.models.Voucher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 29/04/2021
 */
@Mapper
public interface VoucherMapper {
    VoucherMapper INSTANCE = Mappers.getMapper(VoucherMapper.class);

    VoucherResponse toVoucherResponse(Voucher voucher);
}
