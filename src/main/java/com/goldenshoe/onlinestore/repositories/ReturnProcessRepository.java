package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.ReturnProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 02/05/2021
 */
@Repository
public interface ReturnProcessRepository extends JpaRepository<ReturnProcess, Long> {
}
