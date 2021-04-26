package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.models.Shoe;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
public interface ShoeService {
    List<ShoeDto> getAllShoes();

    ShoeDto getShoeById(Long id);
}
