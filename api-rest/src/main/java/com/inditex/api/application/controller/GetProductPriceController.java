package com.inditex.api.application.controller;

import com.inditex.api.application.controller.mapper.ProductPriceControllerMapper;
import com.inditex.api.application.model.dto.ProductPriceRequestDto;
import com.inditex.api.application.model.dto.ProductPriceResponseDto;
import com.inditex.api.application.usecase.ProductPriceUseCase;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling product price requests.
 */
@RestController
@RequestMapping("/api/v1/product") 
public class GetProductPriceController {

    @Autowired
    public GetProductPriceController(ProductPriceUseCase productPriceUseCase, ProductPriceControllerMapper productPriceControllerMapper) {
        this.productPriceUseCase = productPriceUseCase;
        this.productPriceControllerMapper = productPriceControllerMapper;
    }

    private final ProductPriceUseCase productPriceUseCase;

    private final ProductPriceControllerMapper productPriceControllerMapper;

    /**
     * search the product price by product id, brand id and date
     * @param productPriceRequest product price reqeust
     * @return the product price
     */
    @GetMapping
    public ResponseEntity<ProductPriceResponseDto> getProductPrice( @Valid @RequestBody ProductPriceRequestDto productPriceRequest) {
        return ResponseEntity.ok(this.productPriceControllerMapper.responseToDto
                (this.productPriceUseCase.getProductPrice(this.productPriceControllerMapper.requestToDomain(productPriceRequest))));
    }
}
 