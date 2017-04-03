package org.auctionproject.web.validation;

import org.auctionproject.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bishal on 3/31/17.
 */
public class EmailAlreadyExistsValidator implements ConstraintValidator<EmailAlreadyExists, String> {

    @Autowired
    UserService service;

    @Override
    public void initialize(final EmailAlreadyExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {
        return (emailExists(email));
    }

    private boolean emailExists(String email){
        return service.hasEmail(email);
    }
}
