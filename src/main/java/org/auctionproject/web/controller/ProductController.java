package org.auctionproject.web.controller;

import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.exceptions.ProductNotFoundException;
import org.auctionproject.web.facade.IAuthFacade;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
import org.auctionproject.web.service.CategoryService;
import org.auctionproject.web.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by Bishal Paudel on 3/27/17.
 */
@Controller
@RequestMapping(value = "/products")
@EnableSpringDataWebSupport
public class ProductController {

    public static final String PRODUCT_FORM = "create";
    public static final String ACCESS_DENIED = "accessDenied";
    public static final String LISTING_VIEW = "index";

    public static final String REDIRECT_PREFIX = "redirect:/";
    public static final String REDIRECT_PRODUCT_LISTING = REDIRECT_PREFIX + "products";

    private ProductService productService;

    private CategoryService categoryService;

    private ModelMapper modelMapper;

    private IAuthFacade authFacade;

    @Autowired
    public ProductController(ProductService productService,
                      CategoryService categoryService,
                      ModelMapper modelMapper,
                      IAuthFacade authFacade){
        this.productService = productService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.authFacade = authFacade;

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, Pageable pageRequest) {
        Page<Product> products = productService.getAllActiveProducts(pageRequest);
        model.addAttribute("products", products);
        return LISTING_VIEW;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(@ModelAttribute("product") ProductDTO product, Model model) {
        HashMap<Long, String> categories = categoryService.getMapOfIdAndName();
        model.addAttribute("categories", categories);
        return PRODUCT_FORM;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@Valid @ModelAttribute("product") ProductDTO productDTO,
                             BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return PRODUCT_FORM;
        }

        Product product = modelMapper.map(productDTO, Product.class);

        User user = authFacade.getAuthenticatedUser();
        product.setOwner(user);
        productService.createProduct(product);

        /* TODO: Get localized redirection message */
        redirectAttributes.addFlashAttribute("statusMessage", "Product created Successfully");

        /* TODO: Save Photos for product */

        return REDIRECT_PRODUCT_LISTING;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUpdate(@PathVariable("id") Integer productId, Model model) {

        if( ! productService.isOwner(productId, authFacade.getAuthenticatedUser())){
            return ACCESS_DENIED;
        }

        Product product = productService.findById(productId);

        ProductDTO productDTO  = modelMapper.map(product, ProductDTO.class);
        HashMap<Long, String> categories = categoryService.getMapOfIdAndName();
        model.addAttribute("product", productDTO);
        model.addAttribute("categories", categories);

        return PRODUCT_FORM;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String postUpdate(@Valid @ModelAttribute("product") ProductDTO productDTO,
                             @PathVariable("id") Integer productId,
                             BindingResult result,
                             RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return PRODUCT_FORM;
        }

        if( ! productService.isOwner(productId, authFacade.getAuthenticatedUser())){
            return ACCESS_DENIED;
        }

        try{
            productService.update(productId, productDTO);
        }catch (ProductNotFoundException e){
            throw e;
        }

        /* TODO: Get localized redirection message */
        redirectAttributes.addFlashAttribute("statusMessage", "Product saved Successfully");

        /* TODO: Save Photos for product */

        return REDIRECT_PRODUCT_LISTING;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Integer productId,
                                RedirectAttributes redirectAttributes){
        /* TODO: Use ACL */
        if( ! productService.isOwner(productId, authFacade.getAuthenticatedUser())){
            return ACCESS_DENIED;
        }

        if( ! productService.isDetetable(productId)){
            /* TODO: Get localized redirection message */
            /* TODO: Include reason (for not deleting) in the message */
            redirectAttributes.addFlashAttribute("statusMessage", "Product Cannot be deleted.");
            return REDIRECT_PRODUCT_LISTING;
        }

        productService.delete(productId);

        /* TODO: Get localized redirection message */
        redirectAttributes.addFlashAttribute("statusMessage", "Product deleted Successfully.");

        /* TODO: Save Photos for product */

        return REDIRECT_PRODUCT_LISTING;
    }
}
