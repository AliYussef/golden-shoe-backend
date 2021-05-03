package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.VoucherResponse;
import com.goldenshoe.onlinestore.services.VoucherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aliyussef on 29/04/2021
 */
@RestController
@RequestMapping("api/v1/vouchers")
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("check/{code}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Check voucher validity and its discount percentage")
    public VoucherResponse checkVoucher(@PathVariable String code) {
        return voucherService.checkVoucher(code);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get voucher by id.")
    public VoucherResponse getVoucherById(@PathVariable Long id) {
        return voucherService.getVoucherById(id);
    }

}
