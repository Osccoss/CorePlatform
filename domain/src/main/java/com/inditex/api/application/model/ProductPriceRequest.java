package com.inditex.api.application.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * product price request
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceRequest {
    
    private String brandId;

    private String productId;

    private LocalDateTime searchDate;
}
