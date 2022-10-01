package com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator;

import com.karthakkar.MonetaGo.MonetaGoAPI.exception.RequestValidationException;

/**
 * Abstract Class to be extended to make it easier to construct the error message that is to be returned.
 */
public class AbstractRequestValidator {

    protected final void buildErrorMessageThenThrow(String path, String cause) throws RequestValidationException {
        String errorMessage = path + " " + cause;
        throw new RequestValidationException(errorMessage);
    }
}
