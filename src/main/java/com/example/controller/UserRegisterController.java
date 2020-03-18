package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserRegisterForm;
import com.example.service.UserRegisterService;

@Controller
@RequestMapping("/register")
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@ModelAttribute
	public UserRegisterForm setUpUserRegisterForm() {
		return new 	UserRegisterForm();
	}
	
	@RequestMapping("")
	public String toRegister() {
		return "register_user";
	}
	
	@RequestMapping("/insert")
		public String insert(@Validated UserRegisterForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register_user";
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		userRegisterService.insert(user);
		return "login";	
	}
	
	
	

}
