package com.inditex.api.application.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * product price response
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponse implements Serializable {
    private String productId;
    private String brandId;
    private Double price;
    private String priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
