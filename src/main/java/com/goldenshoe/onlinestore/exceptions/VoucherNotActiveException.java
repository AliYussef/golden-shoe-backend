package com.goldenshoe.onlinestore.exceptions;

/**
 * Created by aliyussef on 01/05/2021
 */
public class VoucherNotActiveException extends RuntimeException {
    public VoucherNotActiveException() {
        super();
    }

    public VoucherNotActiveException(String message) {
        super(message);
    }

    public VoucherNotActiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoucherNotActiveException(Throwable cause) {
        super(cause);
    }

    protected VoucherNotActiveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
