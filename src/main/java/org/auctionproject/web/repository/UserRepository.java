package org.auctionproject.web.repository;
import org.auctionproject.web.model.User;
//import org.auctionproject.web.model.UserCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User getUserById(@Param("id") Long id);
    User findByEmail(String email);
    User findByUserName(String userName);
}
