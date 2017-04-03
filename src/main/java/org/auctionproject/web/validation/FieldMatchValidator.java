package org.auctionproject.web.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by bishal on 3/30/17.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String first;

    private String second;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        first = constraintAnnotation.first();
        second = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, first);
            final Object secondObj = BeanUtils.getProperty(value, second);

            return (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        return true;
    }
}
