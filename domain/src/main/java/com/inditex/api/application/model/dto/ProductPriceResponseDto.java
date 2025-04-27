package com.inditex.api.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Product Price Response DTO")
public class ProductPriceResponseDto implements Serializable {
    private String productId;
    private String brandId;
    private Double price;
    private String priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
