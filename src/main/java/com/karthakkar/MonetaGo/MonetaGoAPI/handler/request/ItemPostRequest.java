package com.karthakkar.MonetaGo.MonetaGoAPI.handler.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemPostRequest {
    private String itemId;
    private String desc;
    private Integer qty;
}
