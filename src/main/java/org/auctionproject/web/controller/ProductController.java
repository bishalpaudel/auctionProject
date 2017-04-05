package org.auctionproject.web.controller;

import org.auctionproject.web.dto.ProductDTO;
import org.auctionproject.web.facade.IAuthFacade;
import org.auctionproject.web.model.Product;
import org.auctionproject.web.model.User;
import org.auctionproject.web.service.CategoryService;
import org.auctionproject.web.service.ProductService;
import org.auctionproject.web.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
@RequestMapping(value = "/products")
@EnableSpringDataWebSupport
public class ProductController {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAuthFacade authFacade;


    @RequestMapping(value = "/math", method = RequestMethod.GET)
    public String getnullerror() throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //Pass true flag for multipart message
        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
        mailMsg.setFrom("emailofbishal@gmail.com");
        mailMsg.setTo("ravindra.dhakal7@gmail.com");
        mailMsg.setSubject("Test mail with Attachment");
        mailMsg.setText("Please find Attachment.");
        //FileSystemResource object for Attachment
        //FileSystemResource file = new FileSystemResource(new File("D:/cp/pic.jpg"));
        //mailMsg.addAttachment("myPic.jpg", file);
        mailSender.send(mimeMessage);
        System.out.println("---Done---");
        return "home";
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model, Pageable pageRequest) {
        Page<Product> products = productService.getAllActiveProducts(pageRequest);
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreate(@ModelAttribute("product") ProductDTO product, Model model) {
        HashMap<Long, String> categories = categoryService.getMapOfIdAndName();
        model.addAttribute("categories", categories);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCreate(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model) {
        productDTO.setStatus(Product.PRODUCTSTATUS.ACTIVE);

        if (result.hasErrors()) {
            return "create";
        }

        Product product = modelMapper.map(productDTO, Product.class);

        User user = userService.findUserByUserName(authFacade.getAuthentication().getName());
        product.setOwner(user);
        productService.createProduct(product);

        /* TODO: Save Photos for product */

        return "redirect:/";
    }
}
