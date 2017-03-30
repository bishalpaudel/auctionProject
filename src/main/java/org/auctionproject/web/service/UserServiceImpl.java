package org.auctionproject.web.service;

import java.util.List;

import org.auctionproject.web.model.User;
import org.auctionproject.web.model.UserCredential;
import org.auctionproject.web.repository.UserCredentialsRepository;
import org.auctionproject.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserCredentialsRepository credentials;

	@Override
	public User getUserByUserId(Long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public UserCredential getUserByUserName(String userName) {
		return credentials.getUserByUserName(userName);

	}

	@Override
	public User addUser(User newUser) {
		return userRepository.save(newUser);
	}
	

	// loginvalidation
	@Override
	public Long loginValidation(UserCredential userCredit) {
		String userN = userCredit.getUserName();
		String userP = userCredit.getPassword();
		// System.out.println("user name form form input" + userN);
		UserCredential userCredential = getUserByUserName(userN);
		// System.out.println("From database" + userCredential.getUserName());
		try {
			if ((userN != null) && (userCredential.getUserName().equals(userN))
					&& (userCredential.getPassword().equals(userP))) {
				System.out.println("Login Success");
				return userCredential.getId();
			}

		} catch (NullPointerException exp) {
			System.out.println(exp);
			System.out.println("username and password not match in catch");
			return 0l;
		}
		return 0l;

	}

	@Override
	public User getIdByUserName(String username) {
		 return userRepository.getIdByUserName(username);
		
	}
	@Override
	public User getUserByUserCredentialUserName(String name) {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserCredentialUserName(name);
	}

	@Override
	public User getUserByUserCredentialId(long id) {
		// TODO Auto-generated method stub
		
		return userRepository.getUserByUserCredentialId(id);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
		
	}
}
