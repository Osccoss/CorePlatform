package com.inditex.api.application.facade;

import com.inditex.api.application.model.Prices;
import com.inditex.api.application.model.ProductPriceRequest;

import java.util.List;
import java.util.Optional;

public interface PricesClientFacade {
    /**
     * Retrieves the price of a product based on the provided request.
     *
     * @param productPriceRequest the request containing product and brand information
     * @return the price of the product
     */
    List<Prices> getProductPrice(ProductPriceRequest productPriceRequest);
}
