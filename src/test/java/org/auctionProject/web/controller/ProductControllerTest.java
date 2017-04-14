package org.auctionProject.web.controller;

import org.auctionproject.web.controller.ProductController;
import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.exceptions.ProductNotFoundException;
import org.auctionproject.web.facade.IAuthFacade;
import org.auctionproject.web.model.Category;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
import org.auctionproject.web.service.CategoryService;
import org.auctionproject.web.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by bishal on 3/27/17.
 * Followed from https://github.com/pkainulainen/spring-mvc-test-examples/blob/master/controllers-unittest/src/test/java/net/petrikainulainen/spring/testmvc/todo/controller/StandaloneTodoControllerTest.java
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    MockMvc mockMvc;

    @Mock
    ProductService productService;

    @Mock
    CategoryService categoryService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    IAuthFacade authFacade;

    @InjectMocks
    ProductController productController;

    @Autowired
    private Validator validator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setHandlerExceptionResolvers(exceptionResolver())
                .setValidator(validator)
                .setViewResolvers(getViewResolver())
                .build();
    }

    HandlerExceptionResolver exceptionResolver () {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setDefaultErrorView("defaultException");
        resolver.setDefaultStatusCode(404);
        return resolver;
    }

    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Test
    public void list_shouldCreateProductsListAndRenderListView() throws Exception{
        Page expectedPage = new PageImpl(createFakeProducts());
        when(productService.getAllActiveProducts(any(Pageable.class))).thenReturn(expectedPage);
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name(ProductController.LISTING_VIEW))
                .andExpect(model().attribute("products", expectedPage));
        verify(productService, times(1)).getAllActiveProducts(any(Pageable.class));
    }

    @Test
    public void getCreate_shouldCreateFormObjectAndRenderAddProductForm() throws Exception{
        when(categoryService.getMapOfIdAndName()).thenReturn(createMapOfCategories());
        mockMvc.perform(get("/products/create"))
                .andExpect(status().isOk())
                .andExpect(view().name(ProductController.PRODUCT_FORM))
                .andExpect(model().attribute("categories", createMapOfCategories()))
                .andExpect(model().attribute("product", new ProductDTO()));
        verifyZeroInteractions(productService);
        verify(categoryService, times(1)).getMapOfIdAndName();
    }

    @Test
    public void postCreate_EmptyPostEntry_shouldCreateFormViewAndReturnValidationErrors() throws Exception{
        when(authFacade.getAuthenticatedUser()).thenReturn(createUser());
        when(modelMapper.map(any(ProductDTO.class), eq(Product.class))).thenReturn(createFakeProducts().get(0));
        Product p = new Product();
        p.setOwner(new User());
        when(productService.createProduct(any(Product.class))).thenReturn(p);

        mockMvc.perform(post("/products/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("model", "")
                .param("brand", "")
                .param("category.id", "")
                .param("description", "")
                .param("directBuyPrice", "")
                .param("initialBidAmount", "")
                .param("minBidIncrementAmount", "")
                .param("auctionStartDate", "")
                .param("auctionEndDate", "")
            )
            .andExpect(status().is2xxSuccessful())
            .andExpect(view().name(ProductController.PRODUCT_FORM))
            .andExpect(model().size(1))
            .andExpect(model().hasErrors())
            .andExpect(model().attributeHasFieldErrors("product", "title", "category.id", "initialBidAmount", "minBidIncrementAmount", "brand", "model"))
            .andExpect(model().attributeExists("product"))
            .andExpect(model().attributeHasFieldErrorCode("product", "title", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("product", "category.id", "typeMismatch"))
            .andExpect(model().attributeHasFieldErrorCode("product", "brand", "Length"))
            .andExpect(model().attributeHasFieldErrorCode("product", "model", "Length"))
            .andExpect(model().attributeHasFieldErrorCode("product", "initialBidAmount", "NotNull"))
            .andExpect(model().attributeHasFieldErrorCode("product", "minBidIncrementAmount", "NotNull"))
            .andExpect(model().attributeErrorCount("product", 6));
        verifyZeroInteractions(productService);
    }

    @Test
    public void postCreate_NewProductDTO_shouldCreateProductAndRedirectToProductList() throws Exception{
        when(authFacade.getAuthenticatedUser()).thenReturn(createUser());
        when(modelMapper.map(any(ProductDTO.class), eq(Product.class))).thenReturn(createFakeProducts().get(0));
        Product p = new Product();
        p.setOwner(new User());
        when(productService.createProduct(any(Product.class))).thenReturn(p);

        mockMvc.perform(post("/products/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "-->Title")
                .param("model", "-->Title")
                .param("brand", "-->Title")
                .param("category.id", "1")
                .param("description", "-->Title")
                .param("directBuyPrice", "10.00")
                .param("initialBidAmount", "5.00")
                .param("minBidIncrementAmount", "2")
                .param("auctionStartDate", "2020-10-10 05:05:05")
                .param("auctionEndDate", "2020-10-10 05:05:05")
            )
            .andExpect(model().attributeDoesNotExist("product"))
            .andExpect(model().hasNoErrors())
            .andExpect(model().size(0))
            .andExpect(status().is3xxRedirection())
            .andExpect(flash().attribute("statusMessage", is("Product created Successfully")))
            .andExpect(redirectedUrl("/products"));
        verify(productService, times(1)).createProduct(any(Product.class));

    }

    @Test
    public void getUpdate_ProductNotFound_ShouldCreate404View() throws Exception{
        when(productService.isOwner(any(Integer.class), any(User.class))).thenThrow(new ProductNotFoundException("Product not found"));
        when(productService.findById(any(Integer.class))).thenThrow(new ProductNotFoundException("Product not found"));
        mockMvc.perform(get("/products/update/{id}", 1))
                .andExpect(status().isNotFound())
                .andExpect(model().attributeDoesNotExist("product", "categories"))
                .andExpect(view().name("defaultException"))
                .andExpect(forwardedUrl("/WEB-INF/views/defaultException.jsp"));
    }

    @Test
    public void getUpdate_shouldCreateFormObjectAndRenderAddProductForm() throws Exception{
        when(productService.isOwner(any(Integer.class), any(User.class))).thenReturn(true);
        when(productService.findById(any(Integer.class))).thenReturn(createFakeProducts().get(0));
        when(categoryService.getMapOfIdAndName()).thenReturn(createMapOfCategories());
        when(modelMapper.map(any(Product.class), eq(ProductDTO.class))).thenReturn(createProductDTO());

        mockMvc.perform(get("/products/update/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists( "product", "categories"))
                .andExpect(model().attribute("categories", createMapOfCategories()))
                .andExpect(model().attribute("product", createProductDTO()))
                .andExpect(view().name(ProductController.PRODUCT_FORM));

        verify(productService, times(1)).isOwner(any(Integer.class), any(User.class));
        verify(productService, times(1)).findById(any(Integer.class));
        verify(categoryService, times(1)).getMapOfIdAndName();
    }



    private List<Product> createFakeProducts() {

        Category c1 = createCategory();

        User u1 = createUser();

        Product p1 = new Product();
        p1.setId(1);
        p1.setTitle("Title1");
        p1.setModel("Model1");
        p1.setBrand("Brand1");
        p1.setDescription("Description1");
        p1.setDirectBuyPrice(100.00);
        p1.setInitialBidAmount(50.00);
        p1.setMinBidIncrementAmount(5.00);
        p1.setAuctionStartDate(new Date());
        p1.setAuctionEndDate(new Date());
        p1.setStatus(Product.PRODUCTSTATUS.ACTIVE);
        p1.setCategory(c1);
        p1.setOwner(u1);

        Product p2 = new Product();
        p2.setId(2);
        p2.setTitle("Title2");
        p2.setModel("Model2");
        p2.setBrand("Brand2");
        p2.setDescription("Description2");
        p2.setDirectBuyPrice(100.00);
        p2.setInitialBidAmount(50.00);
        p2.setMinBidIncrementAmount(5.00);
        p2.setAuctionStartDate(new Date());
        p2.setAuctionEndDate(new Date());
        p2.setStatus(Product.PRODUCTSTATUS.ACTIVE);
        p2.setCategory(c1);
        p2.setOwner(u1);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        return products;
    }

    private Category createCategory(){
        Category c1 = new Category();
        c1.setId(1);
        c1.setName("Category1");
        return c1;
    }

    private HashMap<Long, String> createMapOfCategories(){
        HashMap<Long,String> mapOfCategories = new HashMap<>();
        mapOfCategories.put(new Long(1), "Category1");
        mapOfCategories.put(new Long(2), "Category2");
        mapOfCategories.put(new Long(3), "Category3");

        return mapOfCategories;
    }

    private ProductDTO createProductDTO(){

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle("title");
        productDTO.setBrand("Brand");
        productDTO.setModel("Model");
        productDTO.setDescription("Description");
        productDTO.setCategory(new Category());
        productDTO.setAuctionStartDate(tomorrow);
        productDTO.setAuctionEndDate(tomorrow);
        productDTO.setDirectBuyPrice(100.00);
        productDTO.setInitialBidAmount(100.00);
        productDTO.setMinBidIncrementAmount(100.00);
        return productDTO;
    }

    private User createUser(){
        User u1 = new User();
        u1.setId(1);
        u1.setUserName("userName1");
        return u1;
    }
}
