package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRegisterRepository;


@Service
public class UserRegisterService {
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	public void insert(User user) {
		userRegisterRepository.insert(user);
	}
	
	

}
