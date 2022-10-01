package com.karthakkar.MonetaGo.MonetaGoAPI.exception;

/**
 * This class throws RunTimeException when there is an invalid input/request body.
 */
public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }
}
