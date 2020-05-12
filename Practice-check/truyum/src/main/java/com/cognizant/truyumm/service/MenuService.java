package com.cognizant.truyumm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyumm.model.Cart;
import com.cognizant.truyumm.model.Menu;
import com.cognizant.truyumm.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	public List<Cart> getMenuCust(){
		List<Menu> menu=(List<Menu>) menuRepository.findAll();
		List<Cart> cart=new ArrayList<>();
		for(Menu m:menu)
		{
			if(m.getActive().equals("Yes"))
			{
				Cart c=new Cart();
				c.setId(m.getId());
				c.setName(m.getName());
				c.setPrice(m.getPrice());
				c.setCategory(m.getCategory());
				c.setFreedelivery(m.getFreedelivery());
				cart.add(c);
				return cart;
				
			}
		}
		return null;
	}
	
	
}
