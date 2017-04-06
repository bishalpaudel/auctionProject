package org.auctionproject.web.facade;

import org.auctionproject.web.model.User;
import org.auctionproject.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Bishal Paudel on 4/5/17.
 */
@Component
public class AuthFacade implements IAuthFacade {

    UserService userService;

    @Autowired
    AuthFacade(UserService userService){
        this.userService = userService;
    }

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public User getAuthenticatedUser(){
        return userService.findUserByUserName(getAuthentication().getName());
    }
}
