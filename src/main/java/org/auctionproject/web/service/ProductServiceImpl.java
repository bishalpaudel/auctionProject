package org.auctionproject.web.service;

import org.auctionproject.web.model.Product;
import org.auctionproject.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bishal Paudel on 4/3/17.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getAllActiveProducts(Pageable pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    public Product createProduct(Product product) {
        product.setStatus(Product.PRODUCTSTATUS.ACTIVE);
        return productRepository.save(product);
    }
}
