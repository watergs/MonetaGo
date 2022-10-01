package com.karthakkar.MonetaGo.MonetaGoAPI.data.converter;

import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.DataTransformPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.response.DataTransformPostResponse;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.response.ElementPostResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is for data transformation of DataTransformPostRequest to DataTransformPostResponse.
 * It converts orderId to integer IDOrder, customerId to integer IDCustomer, ItemPostRequest to
 * Map of <ItemId, ElementPostResponse>
 */
public class DataTransformRequestToResponseDTO {

    public static DataTransformPostResponse convertToResponse(DataTransformPostRequest dataTransformPostRequest) {
        DataTransformPostResponse dataTransformPostResponse = new DataTransformPostResponse();

        dataTransformPostResponse.setIDOrder(Integer.valueOf(dataTransformPostRequest.getOrderId()));
        dataTransformPostResponse.setIDCustomer(Integer.valueOf(dataTransformPostRequest.getCustomerId()));

        Map<String, ElementPostResponse> elementPostResponseList = new HashMap<>();

        dataTransformPostRequest.getItems()
                .forEach(itemPostRequest -> {
                    ElementPostResponse elementPostResponse = new ElementPostResponse();

                    elementPostResponse.setQuantity(itemPostRequest.getQty());
                    elementPostResponse.setTitle(itemPostRequest.getDesc());

                    elementPostResponseList.put(itemPostRequest.getItemId(), elementPostResponse);
                });

        dataTransformPostResponse.setElements(elementPostResponseList);

        return dataTransformPostResponse;
    }
}
