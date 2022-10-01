package com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator.impl;

import com.karthakkar.MonetaGo.MonetaGoAPI.exception.RequestValidationException;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.DataTransformPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.request.ItemPostRequest;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator.AbstractRequestValidator;
import com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator.RequestValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.karthakkar.MonetaGo.MonetaGoAPI.handler.validator.ErrorMessages.*;

/**
 * Validator for data-transform API.
 */
@Component
@Slf4j
public class DataTransformPostRequestValidator extends AbstractRequestValidator implements RequestValidator<DataTransformPostRequest> {

    private final String CUSTOMER_ID = "customer id";
    private final String ORDER_ID = "order id";
    private final String ITEMS = "items";
    private final String ITEM = "item";
    private final String MISSING_ITEM_ID_OR_QUANTITY = "missing id or quantity";
    private final String ITEM_QUANTITY = "Item Quantity";
    private final Pattern pattern = Pattern.compile("\\d+");

    @Override
    public void validate(DataTransformPostRequest dataTransformPostRequest) throws RequestValidationException {
        if(dataTransformPostRequest == null) {
            buildErrorMessageThenThrow(MAIN_BODY, CANNOT_BE_NULL_OR_EMPTY);
        }
        if(StringUtils.isEmpty(dataTransformPostRequest.getCustomerId())) {
            buildErrorMessageThenThrow(CUSTOMER_ID, CANNOT_BE_NULL_OR_EMPTY);
        }
        if(!isNumeric(dataTransformPostRequest.getCustomerId())) {
            buildErrorMessageThenThrow(CUSTOMER_ID, IS_NOT_NUMBER);
        }
        if(StringUtils.isEmpty(dataTransformPostRequest.getOrderId())) {
            buildErrorMessageThenThrow(ORDER_ID, CANNOT_BE_NULL_OR_EMPTY);
        }
        if(!isNumeric(dataTransformPostRequest.getOrderId())) {
            buildErrorMessageThenThrow(ORDER_ID, IS_NOT_NUMBER);
        }
        if(CollectionUtils.isEmpty(dataTransformPostRequest.getItems())) {
            buildErrorMessageThenThrow(ITEMS, CANNOT_BE_NULL_OR_EMPTY);
        }
        List<ItemPostRequest> missingMandatoryParameters = new ArrayList<>();

        missingMandatoryParameters.addAll(dataTransformPostRequest.getItems()
                .stream()
                .filter(itemPostRequest -> StringUtils.isEmpty(itemPostRequest.getItemId()))
                .collect(Collectors.toList()));
        missingMandatoryParameters.addAll(dataTransformPostRequest.getItems()
                .stream()
                .filter(itemPostRequest -> itemPostRequest.getQty() == null || itemPostRequest.getQty() <= 0)
                .collect(Collectors.toList()));

        if(!CollectionUtils.isEmpty(missingMandatoryParameters)) {
            buildErrorMessageThenThrow(ITEM, MISSING_ITEM_ID_OR_QUANTITY);
        }

        List<ItemPostRequest> invalidQuantity = dataTransformPostRequest.getItems()
                .stream()
                .filter(itemPostRequest -> itemPostRequest.getQty() <= 0)
                .collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(invalidQuantity)) {
            buildErrorMessageThenThrow(ITEM_QUANTITY, IS_INVALID);
        }
    }

    private boolean isNumeric(String str) {
        if(StringUtils.isEmpty(str)) {
            return false;
        }
        return pattern.matcher(str).matches();
    }
}
