package com.inditex.api.application.h2.repository;

import com.inditex.api.application.h2.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * PricesRepository is a Spring Data JPA repository interface for managing PricesEntity objects.
 * It provides methods to perform CRUD operations and custom queries on the prices table.
 */
public interface PricesRepository extends JpaRepository<PricesEntity, Long> {

    Optional<List<PricesEntity>> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String brandId, String productId, LocalDateTime startDate,LocalDateTime endDate);
}
