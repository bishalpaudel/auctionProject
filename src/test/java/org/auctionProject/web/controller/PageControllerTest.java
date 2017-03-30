package org.auctionProject.web.controller;

import org.auctionproject.web.controller.PageController;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Controller;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bishal on 3/29/17.
 */
@Controller
public class PageControllerTest {
    @InjectMocks
    PageController controller;

    @BeforeClass
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void homeTest(){
//        Assert.assertEquals(controller.home(), "home");
//    }
    @Test
    public void dashboardTest(){
        Assert.assertEquals(controller.dashboard(), "myProfile");
    }


}
