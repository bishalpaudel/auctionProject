package org.auctionproject.web.service;

import java.util.List;
import org.auctionproject.web.model.User;
import org.auctionproject.web.model.UserCredential;

public interface UserService {

	// access database (get or set)

	User getUserByUserId(Long id);

	UserCredential getUserByUserName(String userName);

	User addUser(User newUser);

	// Login User validation
	public Long loginValidation(UserCredential userCredit);

	User getUserByUserCredentialId(long id);

	User getUserByUserCredentialUserName(String name);
	// biijay

	List<User> findAll();

	public void delete(long id);

	public User getIdByUserName(String username);


}
