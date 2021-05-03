package com.goldenshoe.onlinestore.exceptions;

/**
 * Created by aliyussef on 01/05/2021
 */
public class VoucherExpiredException extends RuntimeException {
    public VoucherExpiredException() {
        super();
    }

    public VoucherExpiredException(String message) {
        super(message);
    }

    public VoucherExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherExpiredException(Throwable cause) {
        super(cause);
    }

    protected VoucherExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
