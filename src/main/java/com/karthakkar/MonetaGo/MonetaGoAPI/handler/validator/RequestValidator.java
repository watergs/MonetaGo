package com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator;

import com.karthakkar.MonetaGo.MonetaGoAPI.exception.RequestValidationException;

/**
 * The interface for implementing validation. All validation classes must implement this function.
 * @param <Request>
 */
public interface RequestValidator<Request> {
    void validate(Request request) throws RequestValidationException;
}
