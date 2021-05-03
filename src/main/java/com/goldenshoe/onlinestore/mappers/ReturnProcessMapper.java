package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ReturnProcessResponse;
import com.goldenshoe.onlinestore.models.ReturnProcess;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 02/05/2021
 */
@Mapper
public interface ReturnProcessMapper {
    ReturnProcessMapper INSTANCE = Mappers.getMapper(ReturnProcessMapper.class);

    ReturnProcessResponse toReturnProcessResponse(ReturnProcess returnProcess);
}
