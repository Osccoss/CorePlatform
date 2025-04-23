package com.inditex.api.application.controller;

import com.inditex.api.application.controller.mapper.ProductPriceControllerMapper;
import com.inditex.api.application.model.dto.ProductPriceRequestDto;
import com.inditex.api.application.usecase.ProductPriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetProductPriceControllerTest {

    @Mock
    private ProductPriceUseCase productPriceUseCase;
    @Mock
    private ProductPriceControllerMapper productPriceControllerMapper;

    @InjectMocks
    private GetProductPriceController getProductPriceController;
    
    @Test
    void getProductPrice() {
        getProductPriceController.getProductPrice(ProductPriceRequestDto.builder().build());
    }
}