package org.auctionproject.web.service;

import java.util.List;

import org.auctionproject.web.dto.UserDTO;
import org.auctionproject.web.model.Role;
import org.auctionproject.web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	User getUserByUserId(Long id);

//	UserCredential findUserByUserName(String userName);

	User addUser(UserDTO newUser, Role role) throws Exception;

//	public Long loginValidation(UserCredential userCredit);

//	User getUserByUserCredentialId(long id);
//
//	User getUserByUserCredentialUserName(String name);

	List<User> findAll();

	void delete(long id);

    boolean hasEmail(String email);

    User findUserByUserName(String name);

//	public User getIdByUserName(String username);


}
