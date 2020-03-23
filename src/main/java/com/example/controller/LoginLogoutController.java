package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.LoginUser;

@Controller
@RequestMapping("/login")
public class LoginLogoutController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String login(Model model, @RequestParam(required = false) String error) {
		if(error != null) {
			model.addAttribute("inputError", "メールアドレスまたはパスワードが不正です");
		}
		return "login";
	}
	
	@RequestMapping("/after_login")
	public String afterLogin(@AuthenticationPrincipal LoginUser loginUser,Model model) {
		return "forward:/";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "forward:/";
		
	}
	

}
