package org.auctionproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
public class ProductController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "homeView";
    }
}
