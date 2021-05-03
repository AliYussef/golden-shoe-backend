package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShipperResponse;

import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
public interface ShipperService {
    List<ShipperResponse> getAllShippers();
}
