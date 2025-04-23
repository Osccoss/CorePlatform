package com.inditex.api.application.model.dto;

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
    
    private String brandId;
    private String productId;
    private LocalDateTime searchDate;
}
