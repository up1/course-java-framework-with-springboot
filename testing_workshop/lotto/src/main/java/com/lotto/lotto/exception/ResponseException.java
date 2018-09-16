package com.lotto.lotto.exception;

import java.util.Date;

public class ResponseException {
    private String message;
    private Date date = new Date(System.currentTimeMillis());

    public ResponseException() {
    }

    public ResponseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
