package org.auctionproject.web.controller;

import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.model.Category;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
import org.auctionproject.web.service.CategoryService;
import org.auctionproject.web.service.ProductService;
import org.auctionproject.web.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
@RequestMapping(value = "/products")
@EnableSpringDataWebSupport
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, Pageable pageRequest) {
        Page<Product> products = productService.getAllActiveProducts(pageRequest);
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(@ModelAttribute("product") ProductDTO product, Model model) {
        /* TODO: Send all categories */
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model) {
        productDTO.setStatus(Product.PRODUCTSTATUS.ACTIVE);

        if (result.hasErrors()) {
            return "create";
        }


        Product product = modelMapper.map(productDTO, Product.class);
        Category category = categoryService.getById(new Long(1));
        User user = userService.getUserByUserId(new Long(1));
        product.setCategory(category);
        product.setOwner(user);
//        product.setStatus(Product.PRODUCTSTATUS.ACTIVE);
        System.out.println("helloooo000000000000000000000000000000000000000000000000000");
        productService.createProduct(product);


//        System.out.println(product.getAuctionEndDate());
        /* TODO: Use Model Mapper http://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application */
        /* TODO: Save data */
        return "redirect:/home";
    }
}
