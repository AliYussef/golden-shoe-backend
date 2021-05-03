package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ReturnRequest;
import com.goldenshoe.onlinestore.dtos.ReturnResponse;

import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
public interface ReturnService {
    ReturnResponse requestProductReturn(List<ReturnRequest> requests);
}
