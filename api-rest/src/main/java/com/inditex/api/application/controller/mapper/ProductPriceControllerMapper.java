package com.inditex.api.application.controller.mapper;

import com.inditex.api.application.model.dto.ProductPriceRequestDto;
import com.inditex.api.application.model.dto.ProductPriceResponseDto;
import com.inditex.api.application.model.ProductPriceRequest;
import com.inditex.api.application.model.ProductPriceResponse;
import org.mapstruct.Mapper;

/**
 * mapper for controller of product price
 */
@Mapper(componentModel = "spring")
public interface ProductPriceControllerMapper {
    ProductPriceResponseDto responseToDto(ProductPriceResponse productPrice);
    ProductPriceRequest requestToDomain(ProductPriceRequestDto productPriceRequest);
}
