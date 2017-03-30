package org.auctionproject.web.service;

import org.auctionproject.web.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by bishal on 3/29/17.
 */
@Service
public interface UserService {
    User getUserByUsername(String username);
}
