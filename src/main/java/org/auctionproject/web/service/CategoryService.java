package org.auctionproject.web.service;

import org.auctionproject.web.model.Category;

import java.util.HashMap;

/**
 * Created by Bishal Paudel on 4/4/17.
 */
public interface CategoryService {
    Category getById(Long id);

    HashMap<Long, String> getMapOfIdAndName();
}
