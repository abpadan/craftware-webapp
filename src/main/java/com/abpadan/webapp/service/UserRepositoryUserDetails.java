package com.abpadan.webapp.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.abpadan.webapp.domain.Role;
import com.abpadan.webapp.domain.User;

public class UserRepositoryUserDetails extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user; 
	
	public UserRepositoryUserDetails(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().getName()));
		this.user = user; 
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getId() {
		return user.getId();
	}

	public Role getRole() {
		return user.getRole();
	}
	
}
