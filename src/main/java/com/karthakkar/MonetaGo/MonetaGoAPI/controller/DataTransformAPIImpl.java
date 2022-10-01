package com.karthakkar.MonetaGo.MonetaGoAPI.controller;

import com.karthakkar.MonetaGo.MonetaGoAPI.api.DataTransformAPI;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.impl.DataTransformPostHandler;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.DataTransformPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.response.DataTransformPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class of the Data-Transform API.
 */
@RestController
public class DataTransformAPIImpl implements DataTransformAPI {

    @Autowired
    private DataTransformPostHandler dataTransformPostHandler;

    @Override
    public ResponseEntity<DataTransformPostResponse> dataTransform(DataTransformPostRequest request) {
        return (ResponseEntity<DataTransformPostResponse>) dataTransformPostHandler.handle(request);
    }
}
