package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
