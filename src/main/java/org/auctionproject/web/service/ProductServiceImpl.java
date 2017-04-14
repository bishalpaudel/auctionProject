package org.auctionproject.web.service;

import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.exceptions.ProductNotFoundException;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
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

    @Transactional(readOnly = true)
    public Page<Product> getAllActiveProducts(Pageable pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    public Product createProduct(Product product) {
        product.setStatus(Product.PRODUCTSTATUS.ACTIVE);
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Integer productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public void mapDtoIntoModel(ProductDTO productDTO, Product product) {
        product.setBrand(productDTO.getBrand());
        product.setTitle(productDTO.getTitle());
        product.setModel(productDTO.getModel());
        product.setDescription(productDTO.getDescription());
        product.setDirectBuyPrice(productDTO.getDirectBuyPrice());
        product.setInitialBidAmount(productDTO.getInitialBidAmount());
        product.setMinBidIncrementAmount(productDTO.getMinBidIncrementAmount());
        product.setAuctionStartDate(productDTO.getAuctionStartDate());
        product.setAuctionEndDate(productDTO.getAuctionEndDate());
        product.setCategory(productDTO.getCategory());
    }

    @Override
    public void update(Integer productId, ProductDTO productDTO) {
        Product product = findById(productId);
        if(product == null){
            throw new ProductNotFoundException();
        }
        mapDtoIntoModel(productDTO, product);
        productRepository.save(product);
    }

    @Override
    public boolean isOwner(Integer productId, User authenticatedUser) {
        Product product = findById(productId);
        if(product == null){
            throw new ProductNotFoundException();
        }
        return product.getOwner().getId() == authenticatedUser.getId();
    }

    @Override
    public void delete(Integer productId) {
        productRepository.delete(productId);
    }

    @Override
    public boolean isDetetable(Integer productId) {
        /* TODO: Include proper logic such as: [1. Bidding has started], [2. Is Already deleted], etc */
        return true;
    }
}
