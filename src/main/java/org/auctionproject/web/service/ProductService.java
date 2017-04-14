package org.auctionproject.web.service;

import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by bishal on 4/3/17.
 */

public interface ProductService {
    Page<Product> getAllActiveProducts(Pageable pageRequest);

    Product createProduct(Product product);

    Product findById(Integer productId);

    void mapDtoIntoModel(ProductDTO productDTO, Product product);

    void update(Integer productId, ProductDTO productDTO);

    boolean isOwner(Integer productId, User authenticatedUser);

    void delete(Integer productId);

    boolean isDetetable(Integer productId);
}
