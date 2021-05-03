package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.VoucherResponse;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.exceptions.VoucherExpiredException;
import com.goldenshoe.onlinestore.exceptions.VoucherNotActiveException;
import com.goldenshoe.onlinestore.mappers.VoucherMapper;
import com.goldenshoe.onlinestore.models.Voucher;
import com.goldenshoe.onlinestore.repositories.VoucherRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by aliyussef on 29/04/2021
 */
@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;
    private final VoucherMapper voucherMapper;

    public VoucherServiceImpl(VoucherRepository voucherRepository, VoucherMapper voucherMapper) {
        this.voucherRepository = voucherRepository;
        this.voucherMapper = voucherMapper;
    }

    @Override
    public VoucherResponse checkVoucher(String code) {
        Optional<Voucher> voucher = voucherRepository.getVoucherByCode(code);

        if (voucher.isEmpty()) {
            throw new ResourceNotFoundException(MessageFormat.format("Voucher with code: {0} does not exist!", code));
        }

        if (voucher.get().isActive()) {

            if (voucher.get().getExpiryDate().compareTo(LocalDate.now()) >= 0) {
                return voucherMapper.toVoucherResponse(voucher.get());
            } else {
                throw new VoucherExpiredException(MessageFormat.format("Voucher with code: {0} has expired!", code));
            }
        } else {
            throw new VoucherNotActiveException(MessageFormat.format("Voucher with code: {0} has already been used!", code));
        }
    }

    @Override
    public VoucherResponse getVoucherById(Long id) {
        return voucherMapper.toVoucherResponse(voucherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOt found")));
    }
}
