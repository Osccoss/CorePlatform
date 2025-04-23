package com.inditex.api.application.usecase;

import com.inditex.api.application.model.ProductPriceRequest;
import com.inditex.api.application.model.ProductPriceResponse;

/**
 * ProductPriceUseCase interface defines the contract for use cases related to product pricing.
 */
public interface ProductPriceUseCase{
    
    ProductPriceResponse getProductPrice(ProductPriceRequest productPriceRequestDto);
}
