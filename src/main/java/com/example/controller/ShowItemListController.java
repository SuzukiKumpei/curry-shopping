package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemListService;

@Controller
@RequestMapping("/")
public class ShowItemListController {
	
	@Autowired
	private ShowItemListService showItemListService;
	
	@RequestMapping("")
	public String showList(Model model) {
		List<Item> itemList = showItemListService.showList();
		//model.addAttribute("itemList", itemList);
		//System.out.println(itemList);
		
		List<List<Item>> listOfItemList = getThreeItemList(itemList);
		model.addAttribute("listOfItemList", listOfItemList);
		return "item_list_curry";
	}
	
	private List<List<Item>> getThreeItemList(List<Item> itemList) {
		List<List<Item>> itemListList = new ArrayList<>();
		List<Item> threeItemList = new ArrayList<>();

		for (int i = 1; i <= itemList.size(); i++) {
			threeItemList.add(itemList.get(i - 1));

			if (i % 3 == 0 || i == itemList.size()) {
				itemListList.add(threeItemList);
				threeItemList = new ArrayList<>();
			}
		}
		return itemListList;
	}

}
