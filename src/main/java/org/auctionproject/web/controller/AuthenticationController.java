package org.auctionproject.web.controller;

import org.auctionproject.web.model.User;
import org.auctionproject.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by ravindra on 3/28/17.
 */
@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.invalidate();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("registerNewUser") User newUser, Model model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("registerNewUser") User newUser, BindingResult result
                                  /*@RequestParam(value = "picture", defaultValue = "") CommonsMultipartFile picture */, Model model)
            throws FileNotFoundException {
        if (result.hasErrors()) {
            return "register";
        }

        newUser = userService.addUser(newUser);
//
//        MultipartFile userImage = picture;
//        String separator = File.separator;
//
//        String rootDirectory = servletContext.getRealPath("/");
//        if (userImage != null && !userImage.isEmpty()) {
//            try {
//                userImage.transferTo(new File(rootDirectory + "resources" + separator + "img" + separator + "users_"
//                        + newUser.getUserId() + ".jpg"));
//            } catch (Exception e) {
//                throw new FileNotFoundException("Unable to save image: " + userImage.getOriginalFilename());
//            }
//        }
        return "redirect:/users";
    }

}
