package com.karthakkar.MonetaGo.MonetaGoAPI.handler.impl;

import com.karthakkar.MonetaGo.MonetaGoAPI.data.converter.DataTransformRequestToResponseDTO;
import com.karthakkar.MonetaGo.MonetaGoAPI.exception.InvalidRequestException;
import com.karthakkar.MonetaGo.MonetaGoAPI.exception.RequestValidationException;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.AbstractRequestHandler;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.RequestHandler;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.DataTransformPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.response.DataTransformPostResponse;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator.impl.DataTransformPostRequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Handler for the data-transform API. This class has custom implementation of validator, and returns the proper
 * response object with the correct status and headers. It also triggers the operation of the API.
 */
@Slf4j
@Component
public class DataTransformPostHandler extends AbstractRequestHandler<DataTransformPostRequest> implements RequestHandler<DataTransformPostRequest> {

    @Autowired
    private DataTransformPostRequestValidator validator;

    @Override
    public void validateRequest(DataTransformPostRequest dataTransformPostRequest) {
        try {
            validator.validate(dataTransformPostRequest);
        } catch (RequestValidationException e) {
            throw new InvalidRequestException(e.getMessage());
        }
    }

    @Override
    protected Object doHandle(DataTransformPostRequest dataTransformPostRequest) {
        DataTransformPostResponse dataTransformPostResponse =
                DataTransformRequestToResponseDTO.convertToResponse(dataTransformPostRequest);
        ResponseEntity<DataTransformPostResponse> dataTransformPostResponseResponseEntity =
                new ResponseEntity<>(dataTransformPostResponse, null, HttpStatus.CREATED);
        return dataTransformPostResponseResponseEntity;
    }
}
