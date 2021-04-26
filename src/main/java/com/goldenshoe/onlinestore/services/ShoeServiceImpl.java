package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.mappers.ShoeMapper;
import com.goldenshoe.onlinestore.models.Shoe;
import com.goldenshoe.onlinestore.models.ShoeTarget;
import com.goldenshoe.onlinestore.repositories.ShoeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 26/04/2021
 */
@Service
public class ShoeServiceImpl implements ShoeService {

    private final ShoeRepository shoeRepository;
    private final ShoeMapper shoeMapper;

    public ShoeServiceImpl(ShoeRepository shoeRepository, ShoeMapper shoeMapper) {
        this.shoeRepository = shoeRepository;
        this.shoeMapper = shoeMapper;
    }

    @Override
    public List<ShoeDto> getAllShoes() {
        return shoeRepository
                .findAll()
                .stream()
                .map(shoeMapper::shoeToShoeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoeDto> getAllShoes(Pageable pageable) {
        return shoeRepository
                .findAll(pageable)
                .stream()
                .map(shoeMapper::shoeToShoeDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoeDto getShoeById(Long id) {
        return shoeMapper.shoeToShoeDto(shoeRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(MessageFormat.format("Shoe with Id: {0} does not exist!", id))));
    }

    @Override
    public List<ShoeDto> getShoesByTarget(ShoeTarget target) {
        return shoeRepository
                .findAllByTarget(target)
                .stream()
                .map(shoeMapper::shoeToShoeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoeDto> getShoesByCategory(String category) {
        return shoeRepository
                .findAll()
                .stream()
                .filter(shoe -> shoe.getCategories().stream().anyMatch(category1 -> category1.getName().equals(category)))
                .map(shoeMapper::shoeToShoeDto)
                .collect(Collectors.toList());
    }
}
