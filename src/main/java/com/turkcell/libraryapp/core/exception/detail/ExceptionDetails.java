package com.turkcell.libraryapp.core.exception.detail;

public class ExceptionDetails {
    private String message;

    public ExceptionDetails(String message) {
        this.message = message;
    }

    public ExceptionDetails() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
