package org.auctionproject.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import org.auctionproject.web.enums.Role;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	@Email
	private String email;
	
	private String userName;
	
	private String password;
	// @Enumerated(EnumType.STRING)
	// @Column(name = "Role")
	// private Role role;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	@Valid
	private AdminCredential adminCredential;

	public Admin() {

	}

	public Admin(long adminId, String fullName, String email, String userName, String password, Role role) {
		super();
		this.adminId = adminId;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		// this.role = role;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
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

	public AdminCredential getAdminCredential() {
		return adminCredential;
	}

	public void setAdminCredential(AdminCredential adminCredential) {
		this.adminCredential = adminCredential;
	}

	// public Role getRole() {
	// return role;
	// }
	//
	//
	// public void setRole(Role role) {
	// this.role = role;
	// }

}
