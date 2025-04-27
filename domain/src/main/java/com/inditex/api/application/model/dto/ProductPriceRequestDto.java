package com.inditex.api.application.model.dto;

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
public class ProductPriceRequestDto {
    
    @NotNull
    private String brandId;
    
    @NotNull
    private String productId;
    
    @NotNull
    private LocalDateTime searchDate;
}
