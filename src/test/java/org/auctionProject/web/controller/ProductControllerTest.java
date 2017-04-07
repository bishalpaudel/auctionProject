package org.auctionProject.web.controller;

import org.auctionproject.web.controller.ProductController;
import org.auctionproject.web.facade.IAuthFacade;
import org.auctionproject.web.service.CategoryService;
import org.auctionproject.web.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by bishal on 3/27/17.
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

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService,
                categoryService,
                modelMapper,
                authFacade))
                .setHandlerExceptionResolvers(exceptionResolver())
//                .setValidator(validator())
                .setViewResolvers(getViewResolver())
                .build();
    }

    HandlerExceptionResolver exceptionResolver () {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
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
    public void listTest(){
        Assert.assertEquals(1, 1);
    }

    @Test
    public void getCreate_shouldCreateFormObjectRenderAddProductForm() throws Exception{
        when(categoryService.getMapOfIdAndName()).thenReturn(createMapOfCategories());
        mockMvc.perform(get("/products/create"))
                .andExpect(status().isOk())
                .andExpect(view().name(ProductController.PRODUCT_FORM))
//                .andExpect(forwardedUrl("WEB-INF/views/frontend/product/create.jsp"))
                .andExpect(model().attribute("categories", createMapOfCategories()))
                .andExpect(model().attribute("product", hasProperty("title", isEmptyOrNullString())));
//                .andExpect(model().attribute("product", hasProperty("id", nullValue())));
        verifyZeroInteractions(productService);
    }

    private HashMap<Long, String> createMapOfCategories(){
        HashMap<Long,String> mapOfCategories = new HashMap<>();
        mapOfCategories.put(new Long(1), "Category1");
        mapOfCategories.put(new Long(2), "Category2");
        mapOfCategories.put(new Long(3), "Category3");

        return mapOfCategories;
    }
}
