package org.auctionproject.web.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.auctionproject.web.dto.UserDTO;
import org.auctionproject.web.model.Role;
import org.auctionproject.web.model.User;
import org.auctionproject.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

    @Autowired
    ServletContext servletContext;


    BCryptPasswordEncoder passwordEncoder;


	public UserServiceImpl(BCryptPasswordEncoder passwordEncoder){
	    this.passwordEncoder = passwordEncoder;
    }

	@Override
    @Transactional(readOnly = true)
	public User getUserByUserId(Long id) {
		return userRepository.getUserById(id);
	}

	@Override
	public User addUser(UserDTO userDTO, Role role, MultipartFile userImage) throws Exception {

		if(emailExist(userDTO.getEmail())){
            throw new Exception("Email already exists:"+ userDTO.getEmail());
        }
        String separator = File.separator;
        String rootDirectory = servletContext.getRealPath("/");
        String userPic = "";
        if (userImage != null && !userImage.isEmpty()) {
            try {
                userImage.transferTo(new File(rootDirectory + "resources" + separator + "img" + separator +
                        userImage.getOriginalFilename()));
                userPic = userImage.getOriginalFilename();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new FileNotFoundException("Unable to save image: " + userImage.getOriginalFilename());
            }
        }

        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhone(userDTO.getPhone());
        user.setStreet(userDTO.getStreet());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setZip(userDTO.getZip());
        user.setCountry(userDTO.getCountry());
        user.setUser_image(userPic);
        role.addUser(user);
        user.addRole(role);
        return userRepository.save(user);
	}

//    @Transactional(readOnly = true)
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

//
//	@Override
//	public Long loginValidation(UserCredential userCredit) {
//		String userN = userCredit.getUserName();
//		String userP = userCredit.getPassword();
//		// System.out.println("user name form form input" + userN);
//		UserCredential userCredential = getUserByUserName(userN);
//		// System.out.println("From database" + userCredential.getUserName());
//		try {
//			if ((userN != null) && (userCredential.getUserName().equals(userN))
//					&& (userCredential.getPassword().equals(userP))) {
//				System.out.println("Login Success");
//				return userCredential.getId();
//			}
//
//		} catch (NullPointerException exp) {
//			System.out.println(exp);
//			System.out.println("username and password not match in catch");
//			return 0l;
//		}
//		return 0l;
//
//	}
//
//	@Override
//	public User getIdByUserName(String username) {
//		 return userRepository.getIdByUserName(username);
//
//	}
//	@Override
//	public User getUserByUserCredentialUserName(String name) {
//		// TODO Auto-generated method stub
//		return userRepository.getUserByUserCredentialUserName(name);
//	}
//
//	@Override
//	public User getUserByUserCredentialId(long id) {
//		// TODO Auto-generated method stub
//
//		return userRepository.getUserByUserCredentialId(id);
//	}
	@Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}

    @Override
    public boolean hasEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
