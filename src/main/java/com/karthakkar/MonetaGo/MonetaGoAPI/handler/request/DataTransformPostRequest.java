package com.karthakkar.MonetaGo.MonetaGoAPI.handler.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * The input/request body for the data-transform API.
 */
@Getter
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DataTransformPostRequest {
    private String orderId;
    private String customerId;
    private List<ItemPostRequest> items;
}
