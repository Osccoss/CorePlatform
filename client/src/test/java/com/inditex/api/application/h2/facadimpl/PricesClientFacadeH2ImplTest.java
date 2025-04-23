package com.inditex.api.application.h2.facadimpl;

import com.inditex.api.application.exception.EntityNotFoundException;
import com.inditex.api.application.h2.entity.PricesEntity;
import com.inditex.api.application.h2.repository.PricesRepository;
import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesClientFacadeH2ImplTest {

    @Mock
    private PricesRepository pricesRepository;
    @InjectMocks
    private PricesClientFacadeH2Impl productPriceUseCase;
    
    @Test
    void getProductPriceNotFoundException() {
        when(pricesRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(any(),any(),any(),any())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () ->
                productPriceUseCase.getProductPrice(ProductPriceRequest.builder().build()));
    }

    @Test
    void getProductPrice() {
        when(pricesRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(any(),any(),any(),any()))
                .thenReturn(Optional.of(List.of(PricesEntity.builder().brandId("1").build())));
        List<Prices> prices = productPriceUseCase.getProductPrice(ProductPriceRequest.builder().build());
        Assertions.assertEquals("1",prices.get(0).getBrandId());
    }
}