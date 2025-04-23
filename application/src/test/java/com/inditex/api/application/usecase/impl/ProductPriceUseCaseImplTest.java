package com.inditex.api.application.usecase.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import com.inditex.api.application.facade.PricesClientFacade;
import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceRequest;
import com.inditex.api.application.model.ProductPriceResponse;
import com.inditex.api.application.usecase.mapper.ProductPriceUseCaseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductPriceUseCaseImplTest {

    @Mock
    private PricesClientFacade pricesClient;
    @Mock
    private ProductPriceUseCaseMapper productPriceMapper;
    @InjectMocks
    private ProductPriceUseCaseImpl productPriceUseCase;
    


    private ProductPriceRequest generateProductPriceRequest() {
        return ProductPriceRequest.builder().productId("12345").brandId("1").searchDate(LocalDateTime.now()).build();
    }

    @Test
    void getProductPrice() {
        Prices priceResult = generatePrices(24.24,2);
        when(pricesClient.getProductPrice(any())).thenReturn(List.of(generatePrices(23.23,0), priceResult));
        
        
        when(productPriceMapper.toResponse(priceResult)).thenReturn(ProductPriceResponse.builder().productId("12345").brandId("1").price(24.24).build());

        ProductPriceResponse response = productPriceUseCase.getProductPrice(generateProductPriceRequest());
        Assertions.assertNotNull(response);
        Assertions.assertEquals("12345", response.getProductId());
    }

    private static Prices generatePrices(Double amount, Integer priority) {
        return Prices.builder().price(amount).productId("12345").priceList(1).brandId("1").currency("EUR").endDate(LocalDateTime.now()).startDate(LocalDateTime.now()).priority(priority).build();
    }
}