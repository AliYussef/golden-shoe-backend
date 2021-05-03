package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ReturnProcessResponse;
import com.goldenshoe.onlinestore.models.ReturnProcess;

import java.util.List;

/**
 * Created by aliyussef on 02/05/2021
 */
public interface ReturnProcessService {
    List<ReturnProcessResponse> getAllReturnProcessSteps();
}
