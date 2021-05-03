package com.goldenshoe.onlinestore.exceptions;

/**
 * Created by aliyussef on 02/05/2021
 */
public class ProductReturnPeriodExpiredException extends RuntimeException{
    public ProductReturnPeriodExpiredException() {
        super();
    }

    public ProductReturnPeriodExpiredException(String message) {
        super(message);
    }

    public ProductReturnPeriodExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductReturnPeriodExpiredException(Throwable cause) {
        super(cause);
    }

    protected ProductReturnPeriodExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
