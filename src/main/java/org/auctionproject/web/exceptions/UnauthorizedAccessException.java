package org.auctionproject.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bishal on 3/30/17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Employee Not Found")
public final class UnauthorizedAccessException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UnauthorizedAccessException() {
        super();
    }

    public UnauthorizedAccessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedAccessException(final String message) {
        super(message);
    }

    public UnauthorizedAccessException(final Throwable cause) {
        super(cause);
    }

}