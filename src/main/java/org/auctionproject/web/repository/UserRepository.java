package org.auctionproject.web.repository;

import org.auctionproject.web.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bishal on 3/29/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserName(String username) throws DataAccessException;
}
