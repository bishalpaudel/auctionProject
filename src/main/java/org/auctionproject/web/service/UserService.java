package org.auctionproject.web.service;

import java.util.List;

import org.auctionproject.web.dto.UserDTO;
import org.auctionproject.web.model.Role;
import org.auctionproject.web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	User getUserByUserId(Long id);

//	UserCredential getUserByUserName(String userName);

	User addUser(UserDTO newUser, Role role) throws Exception;

//	public Long loginValidation(UserCredential userCredit);

//	User getUserByUserCredentialId(long id);
//
//	User getUserByUserCredentialUserName(String name);

	List<User> findAll();

	public void delete(long id);

//	public User getIdByUserName(String username);


}