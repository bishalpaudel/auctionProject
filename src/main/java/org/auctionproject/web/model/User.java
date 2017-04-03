package org.auctionproject.web.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
	public static final int MAX_LENGTH_EMAIL_ADDRESS = 100;
	public static final int MAX_LENGTH_FULLNAME = 50;
	public static final int MAX_LENGTH_USERNAME = 15;
	public static final int MAX_LENGTH_PASSWORD = 20;

	public static final int MIN_LENGTH_USERNAME = 3;
	public static final int MIN_LENGTH_PASSWORD = 6;
	public static final int MIN_LENGTH_FULLNAME = 3;
	public static final int MIN_LENGTH_PHONE = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String fullName;

	@NotEmpty
	@Email
	private String email;
	
	private String userName;
	
	private String password;
	
	private String phone;
	private String street;
	private String city;
	private String state;

	@NotEmpty
	private String zip;
	private String country;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "UserRole", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>(0);


	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long userId) {
		this.id = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

    public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role){
        role.addUser(this);
        roles.add(role);
    }

    @Override
    public String toString() {
        return "Name: " + fullName + ", Email: " + email;
    }

}
