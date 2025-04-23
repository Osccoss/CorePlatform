package com.inditex.api.application.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for product price response
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponseDto implements Serializable {
    private String productId;
    private String brandId;
    private Double price;
    private String priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
