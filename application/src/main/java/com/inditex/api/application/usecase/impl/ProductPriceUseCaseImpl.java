package com.inditex.api.application.usecase.impl;

import com.inditex.api.application.facade.PricesClientFacade;
import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceRequest;
import com.inditex.api.application.model.ProductPriceResponse;
import com.inditex.api.application.usecase.ProductPriceUseCase;
import com.inditex.api.application.usecase.mapper.ProductPriceUseCaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * ProductPriceUseCaseImpl class implements the ProductPriceUseCase interface.
 * It contains the business logic for retrieving product prices.
 */
@Component
public class ProductPriceUseCaseImpl implements ProductPriceUseCase {
    private final PricesClientFacade pricesClient;
    private final ProductPriceUseCaseMapper productPriceMapper;

    @Autowired
    public ProductPriceUseCaseImpl(PricesClientFacade pricesClient, ProductPriceUseCaseMapper productPriceMapper) {
        this.pricesClient = pricesClient;
        this.productPriceMapper = productPriceMapper;
    }

    @Override
    public ProductPriceResponse getProductPrice(ProductPriceRequest productPriceRequestDto) {
        
        List<Prices> prices = this.pricesClient.getProductPrice(productPriceRequestDto);
       return  productPriceMapper.toResponse(prices.stream()
                .max(Comparator.comparingInt(Prices::getPriority)).orElse(null));
    }
}
