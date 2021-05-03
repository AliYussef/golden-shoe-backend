package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by aliyussef on 29/04/2021
 */
@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    Optional<Voucher> getVoucherByCode(String code);
}
