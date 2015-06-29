package com.sandlex.run2gather.exception;

public class R2GException extends Exception {

    public R2GException() {
        super();
    }

    public R2GException(String s) {
        super(s);
    }

    public R2GException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public R2GException(Throwable throwable) {
        super(throwable);
    }
}
