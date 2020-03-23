package com.example.domain;

import org.springframework.security.core.authority.AuthorityUtils;

@SuppressWarnings("serial")
public class LoginUser extends org.springframework.security.core.userdetails.User {
	
	private final User user;
	
	public LoginUser(User user) {
		super(user.getEmail(), user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
}
