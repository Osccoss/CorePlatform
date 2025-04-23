package com.inditex.api.application.h2.facadimpl;

import com.inditex.api.application.facade.PricesClientFacade;
import com.inditex.api.application.exception.EntityNotFoundException;
import com.inditex.api.application.h2.entity.PricesEntity;
import com.inditex.api.application.h2.repository.PricesRepository;
import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * PricesClientFacadeH2Impl is an implementation of the PricesClientFacade interface.
 * It provides a method to manage prices from an H2 database.
 */
@Component
public class PricesClientFacadeH2Impl implements PricesClientFacade {

 
    private PricesRepository pricesRepository;

    @Autowired
    public PricesClientFacadeH2Impl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    /**
     * Retrieves the price of a product based on the provided request.
     *
     * @param productPriceRequest the request containing product and brand information
     * @return the price of the product
     */
    @Override
    public List<Prices> getProductPrice(ProductPriceRequest productPriceRequest) {
        List<PricesEntity> pricesRepositoryResponse = pricesRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual
                (productPriceRequest.getBrandId(),productPriceRequest.getProductId(),productPriceRequest.getSearchDate(),productPriceRequest.getSearchDate())
                .orElseThrow(() -> new EntityNotFoundException("No prices found for the given request"));
        if (pricesRepositoryResponse.isEmpty()) {
            throw new EntityNotFoundException("No prices found for the given request");
        }
        return pricesRepositoryResponse.stream().map(pricesEntity -> 
             Prices.builder()
                    .price(pricesEntity.getPrice())
                    .productId(pricesEntity.getProductId())
                    .priceList(pricesEntity.getPriceList())
                    .brandId(pricesEntity.getBrandId())
                    .currency(pricesEntity.getCurrency())
                    .endDate(pricesEntity.getEndDate())
                    .startDate(pricesEntity.getStartDate())
                    .priority(pricesEntity.getPriority())
                    .build()
        ).toList();
    }
}
