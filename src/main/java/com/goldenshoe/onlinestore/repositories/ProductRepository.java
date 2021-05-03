package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.Product;
import com.goldenshoe.onlinestore.models.ProductTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTarget(ProductTarget target);
}
