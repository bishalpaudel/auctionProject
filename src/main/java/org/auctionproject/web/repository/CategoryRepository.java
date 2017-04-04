package org.auctionproject.web.repository;

import org.auctionproject.web.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bishal Paudel on 4/4/17.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
