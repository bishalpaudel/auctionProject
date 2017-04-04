package org.auctionproject.web.service;

import org.auctionproject.web.model.Category;
import org.auctionproject.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bishal Paudel on 4/4/17.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.findOne(id);
    }
}
