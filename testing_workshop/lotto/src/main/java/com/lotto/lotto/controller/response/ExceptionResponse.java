package com.lotto.lotto.controller.response;

import java.util.Date;
import java.util.Objects;

public class ExceptionResponse{

    private Date timestamp = new Date();
    private String message;
    private String detail;

    public ExceptionResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResponse response = (ExceptionResponse) o;
        return Objects.equals(message, response.message) &&
                Objects.equals(detail, response.detail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(message, detail);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
