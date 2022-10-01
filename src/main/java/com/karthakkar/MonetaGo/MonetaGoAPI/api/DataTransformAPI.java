package com.karthakkar.MonetaGo.MonetaGoAPI.api;

import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.DataTransformPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.response.DataTransformPostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for implementation of the API.
 */
public interface DataTransformAPI {

    @PostMapping("/data-transform")
    ResponseEntity<DataTransformPostResponse> dataTransform(@RequestBody DataTransformPostRequest request);
}
