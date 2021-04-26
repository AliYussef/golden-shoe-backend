package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShoeVariantDto;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.mappers.ShoeVariantMapper;
import com.goldenshoe.onlinestore.models.ShoeVariant;
import com.goldenshoe.onlinestore.repositories.ShoeVariantRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 26/04/2021
 */
@Service
public class ShoeVariantServiceImpl implements ShoeVariantService {

    private final ShoeVariantRepository shoeVariantRepository;
    private final ShoeVariantMapper shoeVariantMapper;

    public ShoeVariantServiceImpl(ShoeVariantRepository shoeVariantRepository, ShoeVariantMapper shoeVariantMapper) {
        this.shoeVariantRepository = shoeVariantRepository;
        this.shoeVariantMapper = shoeVariantMapper;
    }

    @Override
    public List<ShoeVariantDto> getAllShoeVariants() {
        return shoeVariantRepository
                .findAll()
                .stream()
                .map(shoeVariantMapper::shoeVariantToShoeVariantDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoeVariantDto getShoeVariantById(Long id) {
        return shoeVariantMapper.shoeVariantToShoeVariantDto(findShoeById(id));
    }

    @Override
    public void updateShoeVariantStock(Long id, int quantity) {
        ShoeVariant shoeVariantSaved = findShoeById(id);
        shoeVariantSaved.setStock(quantity);
        shoeVariantRepository.save(shoeVariantSaved);
    }

    private ShoeVariant findShoeById(Long id) {
        return shoeVariantRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(MessageFormat.format("Shoe with Id: {0} does not exist!", id)));
    }
}
