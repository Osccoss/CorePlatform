package com.inditex.api.application.h2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * PricesEntity class represents the pricing information for a product in the database.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class PricesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @Column(nullable = false)
    private String brandId;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Integer priceList;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String currency;
    
}
