package org.auctionproject.web.facade;

import org.auctionproject.web.model.User;
import org.springframework.security.core.Authentication;

/**
 * Created by Bishal Paudel on 4/5/17.
 */
public interface IAuthFacade {
    Authentication getAuthentication();

    User getAuthenticatedUser();
}
