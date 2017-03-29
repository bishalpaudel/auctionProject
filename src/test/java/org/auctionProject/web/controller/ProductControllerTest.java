package org.auctionProject.web.controller;

import org.auctionproject.web.controller.ProductController;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Controller;
import org.testng.annotations.BeforeClass;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
public class ProductControllerTest {

    @InjectMocks
    ProductController controller;

    @BeforeClass
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
}
