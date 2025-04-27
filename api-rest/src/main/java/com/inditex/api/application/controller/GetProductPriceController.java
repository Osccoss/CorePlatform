package com.inditex.api.application.controller;

import com.inditex.api.application.controller.mapper.ProductPriceControllerMapper;
import com.inditex.api.application.model.dto.ProductPriceRequestDto;
import com.inditex.api.application.model.dto.ProductPriceResponseDto;
import com.inditex.api.application.usecase.ProductPriceUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling product price requests.
 */
@RestController
@RequestMapping("/api/v1/product") 
@Tag(name = "Product Price", description = "retrieving product prices information")
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
    @Operation(
            summary = "Get Product Price",
            description = "Retrieve the price of a product based on product ID, brand ID, and search date.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product price retrieved successfully"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request payload",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Resource not found: No prices found for the given request",
                            content = @Content
                    )
            }
    )
    @GetMapping
    public ResponseEntity<ProductPriceResponseDto> getProductPrice( @Valid @RequestBody ProductPriceRequestDto productPriceRequest) {
        return ResponseEntity.ok(this.productPriceControllerMapper.responseToDto
                (this.productPriceUseCase.getProductPrice(this.productPriceControllerMapper.requestToDomain(productPriceRequest))));
    }
}
 