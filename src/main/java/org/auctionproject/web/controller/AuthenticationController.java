package org.auctionproject.web.controller;

import org.auctionproject.web.dto.UserDTO;
import org.auctionproject.web.model.User;
import org.auctionproject.web.service.RoleService;
import org.auctionproject.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by ravindra on 3/28/17.
 */
@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

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
    public String register(@ModelAttribute("userDTO") UserDTO userDTO , Model model) {
//        model.addAttribute("userDTO", userDTO);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result,
                                  @RequestParam(value = "picture", defaultValue = "") CommonsMultipartFile picture , RedirectAttributes redirectAttrs)
            throws Exception {
        MultipartFile userImage = picture;
        if (result.hasErrors()) {
            return "register";
        }
        try{
            User newUser = userService.addUser(userDTO, roleService.getBasicRole(),userImage);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return "redirect:/login";
    }



//    @ExceptionHandler(UserAlreadyExistsException.class)
//    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", ex);
//        modelAndView.addObject("url", request.getRequestURL());
//
//        modelAndView.setViewName("error");
//        return modelAndView;
//    };;s..

}
