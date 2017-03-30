package org.auctionproject.web.repository;
import org.auctionproject.web.model.User;
import org.auctionproject.web.model.UserCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("select u from USER u where u.userId= :id")
	User getUserById(@Param("id") Long id);
	@Query(value=("select * FROM USER_CREDENTIAL u where u.userName=?1"),nativeQuery=true)
	UserCredential getUserByUserName(String userName);
	
	@Query("select u FROM USER u where u.userCredential.userName=?1")
	User getIdByUserName(String userName);
	
	@Query("select u from USER u where u.userCredential.id= :id")
	User getUserByUserCredentialId(@Param("id") Long id);
	
	@Query(value=("select u from USER u where u.userCredential.userName=?1"))
	User getUserByUserCredentialUserName(String name);
	
}
