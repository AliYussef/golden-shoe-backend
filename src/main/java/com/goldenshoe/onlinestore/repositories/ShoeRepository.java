package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.Shoe;
import com.goldenshoe.onlinestore.models.ShoeTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    List<Shoe> findAllByTarget(ShoeTarget target);
}
