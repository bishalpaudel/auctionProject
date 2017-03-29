package org.auctionproject.web.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by bishal on 3/29/17.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }


    @RequestMapping(value = "/my-profile", method = RequestMethod.GET)
    public String dashboard(){
        return "myProfile";
    }
}
