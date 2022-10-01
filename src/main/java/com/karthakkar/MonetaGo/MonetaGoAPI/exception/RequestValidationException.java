package com.karthakkar.MonetaGo.MonetaGoAPI.exception;

/**
 * Generic Class for throwing exception whenever there is any invalid input found.
 */
public class RequestValidationException extends Exception {

    public RequestValidationException(String message) {
        super(message);
    }
}
