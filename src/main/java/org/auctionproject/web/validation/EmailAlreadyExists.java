package org.auctionproject.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by bishal on 3/31/17.
 */
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailAlreadyExistsValidator.class)
@Documented
public @interface EmailAlreadyExists {

    String message() default "Email does not exist.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}