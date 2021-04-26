package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.models.ShoeTarget;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
public interface ShoeService {
    List<ShoeDto> getAllShoes(Pageable pageable);

    List<ShoeDto> getAllShoes();

    ShoeDto getShoeById(Long id);

    List<ShoeDto> getShoesByTarget(ShoeTarget target);

    List<ShoeDto> getShoesByCategory(String category);
}
