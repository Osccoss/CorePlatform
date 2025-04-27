package com.inditex.api.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO for product price request
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Product Price Request DTO")
public class ProductPriceRequestDto {
    
    @NotNull(message = "Brand ID cannot be null")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "ID of the brand", example = "1")
    private String brandId;
    
    @NotNull(message = "Product ID cannot be null")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "ID of the product", example = "35455")
    private String productId;

    @NotNull(message = "Search date cannot be null")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,  description = "Date to search the product price", example = "2023-10-01T12:00:00")
    private LocalDateTime searchDate;

}
