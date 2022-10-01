package com.karthakkar.MonetaGo.MonetaGoAPI.handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * The response/output object for the data-transform API.
 */
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@JsonPropertyOrder({"IDOrder, IDCustomer, elements"})
public class DataTransformPostResponse {

    @JsonProperty("IDOrder")
    private Integer IDOrder;

    @JsonProperty("IDCustomer")
    private Integer IDCustomer;

    @JsonProperty("Elements")
    private Map<String, ElementPostResponse> elements;
}
