package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.VoucherResponse;

/**
 * Created by aliyussef on 29/04/2021
 */
public interface VoucherService {
    VoucherResponse checkVoucher(String code);

    VoucherResponse getVoucherById(Long id);
}
