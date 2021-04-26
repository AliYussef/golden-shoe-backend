package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
