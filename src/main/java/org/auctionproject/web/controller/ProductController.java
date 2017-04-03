package org.auctionproject.web.controller;

import org.auctionproject.web.model.Product;
import org.auctionproject.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
@RequestMapping(value = "/products/")
@EnableSpringDataWebSupport
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, Pageable pageRequest) {
        Page<Product> products = productService.getAllActiveProducts(pageRequest);
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "create";
    }
}
