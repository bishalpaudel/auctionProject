package org.auctionproject.web.Exceptions;

/**
 * Created by bishal on 3/30/17.
 */
//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Employee Not Found")
public final class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }

}