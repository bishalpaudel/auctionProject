package org.auctionproject.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bishal on 3/30/17.
 */
/* TODO: Show i18n message */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Product Not Found")
public final class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(final String message) {
        super(message);
    }

    public ProductNotFoundException(final Throwable cause) {
        super(cause);
    }

}