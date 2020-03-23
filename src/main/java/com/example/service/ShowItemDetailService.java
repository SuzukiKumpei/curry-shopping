package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.domain.Topping;
import com.example.repository.ItemRepository;
import com.example.repository.ToppingRepository;

@Service
public class ShowItemDetailService {
	
	@Autowired
	private ToppingRepository toppingRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Topping> getAllToppings(){
		return toppingRepository.findAll();
	}
	
	public Item getItemDetail(Integer id) {
		return itemRepository.load(id);
	}

}
