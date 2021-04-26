package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
