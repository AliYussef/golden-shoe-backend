package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShipperResponse;
import com.goldenshoe.onlinestore.mappers.ShipperMapper;
import com.goldenshoe.onlinestore.repositories.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 01/05/2021
 */
@Service
public class ShipperServiceImpl implements ShipperService {

    private final ShipperRepository shipperRepository;
    private final ShipperMapper shipperMapper;

    public ShipperServiceImpl(ShipperRepository shipperRepository, ShipperMapper shipperMapper) {
        this.shipperRepository = shipperRepository;
        this.shipperMapper = shipperMapper;
    }

    @Override
    public List<ShipperResponse> getAllShippers() {
        return shipperRepository.findAll()
                .stream()
                .map(shipperMapper::toShipperResponse)
                .collect(Collectors.toList());
    }
}
