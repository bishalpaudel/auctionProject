package org.auctionproject.web.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collection;

/**
 * Created by bishal on 3/27/17.
 */
@Controller
@RequestMapping(value = "/products/")
@EnableSpringDataWebSupport
public class ProductController {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    private ProductService productService;


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
    public String create() {
        return "create";
    }
}
