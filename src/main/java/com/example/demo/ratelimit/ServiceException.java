package com.example.demo.ratelimit;

public class ServiceException extends Exception {

    private String message;

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
