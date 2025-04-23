package com.inditex.api.application.usecase.mapper;

import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceResponse;
import org.mapstruct.Mapper;

/**
 * Mapper interface for ProductPriceUseCase.
 */
@Mapper(componentModel = "spring")
public interface ProductPriceUseCaseMapper {
    ProductPriceResponse toResponse(Prices prices);
}
