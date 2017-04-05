package org.auctionproject.web.service;

import com.google.common.collect.Maps;
import org.auctionproject.web.model.Category;
import org.auctionproject.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bishal Paudel on 4/4/17.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public HashMap<Long, String> getMapOfIdAndName() {
        List<Category> categories = categoryRepository.findAll();
        System.out.println(categories);
        HashMap<Long, String> mappedCategories = new HashMap<>();
        for(Category category: categories){
            mappedCategories.put(category.getCategoryId(), category.getName());
        }

        return mappedCategories;
    }
}
