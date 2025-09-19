package com.turkcell.libraryapp.core.exception.type;

public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}