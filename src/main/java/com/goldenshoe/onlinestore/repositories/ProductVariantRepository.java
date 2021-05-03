package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 26/04/2021
 */
@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
