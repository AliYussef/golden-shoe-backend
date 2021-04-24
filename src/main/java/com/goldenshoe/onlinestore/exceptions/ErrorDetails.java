package com.goldenshoe.onlinestore.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by aliyussef on 24/04/2021
 */
@Data
@Builder
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private int statusCode;
}
