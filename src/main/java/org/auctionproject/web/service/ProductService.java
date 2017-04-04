package org.auctionproject.web.service;

import org.auctionproject.web.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by bishal on 4/3/17.
 */
public interface ProductService {
    Page<Product> getAllActiveProducts(Pageable pageRequest);
}
