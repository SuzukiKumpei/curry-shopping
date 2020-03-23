package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ShowItemListController {
	
	@RequestMapping("")
	public String showList() {
		return "item_list_curry";
	}

}
