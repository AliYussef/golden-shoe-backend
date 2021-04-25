package com.goldenshoe.onlinestore.repositories;

import com.goldenshoe.onlinestore.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 25/04/2021
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
