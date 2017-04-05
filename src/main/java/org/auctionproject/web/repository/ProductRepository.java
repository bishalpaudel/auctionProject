package org.auctionproject.web.repository;

import org.auctionproject.web.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bishal on 4/3/17.
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findAll(Pageable pageRequest);
}
