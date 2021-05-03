package com.goldenshoe.onlinestore.exceptions;

/**
 * Created by aliyussef on 01/05/2021
 */
public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException() {
        super();
    }

    public ProductOutOfStockException(String message) {
        super(message);
    }

    public ProductOutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductOutOfStockException(Throwable cause) {
        super(cause);
    }

    protected ProductOutOfStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
