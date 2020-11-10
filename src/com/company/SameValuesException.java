package com.company;

public class SameValuesException extends Exception{
    public SameValuesException() {
    }

    public SameValuesException(String message) {
        super(message);
    }

    public SameValuesException(String message, Throwable cause) {
        super(message, cause);
    }

    public SameValuesException(Throwable cause) {
        super(cause);
    }

    public SameValuesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
