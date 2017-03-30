package org.auctionproject.web.repository;

import org.auctionproject.web.model.UserCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredential, Long>{
	
	@Query(value=("select * FROM USER_CREDENTIAL u where u.userName=?1"),nativeQuery=true)
	UserCredential getUserByUserName(String userName);
}
