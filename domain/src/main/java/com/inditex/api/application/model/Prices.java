package com.inditex.api.application.model;

import lombok.*;

import java.time.LocalDateTime;


/**
 * Prices class represents the pricing information for a product.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    private String brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
    
    private Integer priceList;
    
    private String productId;

    private Integer priority;

    private Double price;

    private String currency;
    
}
