package com.cognizant.truyumm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyumm.TruyummApplication;
import com.cognizant.truyumm.model.Cart;
import com.cognizant.truyumm.model.Menu;
import com.cognizant.truyumm.repository.MenuRepository;
import com.cognizant.truyumm.repository.ProductRepository;
import com.cognizant.truyumm.service.MenuService;

@Controller
public class CartController {

	@Autowired
	MenuRepository menuRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	MenuService menuService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyummApplication.class);
	
	@RequestMapping("/menu-item-list-customer")
	public String showProduct(ModelMap map)
	{
		LOGGER.info("Start");
		List<Cart> cart=menuService.getMenuCust();
		LOGGER.debug("CustomerMenu={}", cart);
		map.put("menulist",cart);
		LOGGER.info("End");
		return "menu-item-list-customer";	
	}
	
	
	@RequestMapping("/menu-item-list-customer-notification")
	public String saveCart(ModelMap map,@RequestParam Integer id)
	{
		LOGGER.info("Start");
	
		 List<Menu> menu=(List<Menu>) menuRepository.findAll();
		 LOGGER.debug("Menu={}", menu);
		 Cart c=new Cart();
		 for(Menu m:menu)
		 {
			 if(m.getId()==id)
			 {
				c.setId(id);
				c.setName(m.getName());
				 c.setFreedelivery(m.getFreedelivery()); 
				c.setPrice(m.getPrice());			
				 c.setCategory(m.getCategory());
				 
			 }
		 }
			
			
		
		 productRepository.save(c);
		
		 List<Menu> menu1=(List<Menu>) menuRepository.findAll();
			List<Cart> cart=new ArrayList<>();
			for(Menu m:menu1)
			{
				if(m.getActive().equals("Yes"))
				{
					Cart c1=new Cart();
					c1.setId(m.getId());
					c1.setName(m.getName());
					c1.setPrice(m.getPrice());
					c1.setCategory(m.getCategory());
					c1.setFreedelivery(m.getFreedelivery());
					cart.add(c1);
					
				}
			}
			map.put("cartlist",cart);
			
			LOGGER.info("End");
		 
		return "menu-item-list-customer-notification";	
	}
	
	
	
	
	@RequestMapping("/cart-notification")
	public String deletefromCart(ModelMap map,@RequestParam Integer id)
	{
		LOGGER.info("Start");
			
		
		
		
		productRepository.deleteById(id);
		 List<Cart> cart=(List<Cart>) productRepository.findAll();
		 LOGGER.debug("CartAfterDelete={}", cart);
		if(cart.size()>0)	
		{ map.put("cartlist",cart);
		LOGGER.info("End");
		return "cart-notification";
		}
		else
		{
			return "cart-empty";
		}
		
	}
	
	@RequestMapping("/cart")
	public String cartItems(ModelMap map) {
		LOGGER.info("Start");
		List<Cart> c=(List<Cart>) productRepository.findAll();
		LOGGER.debug("CartItems={}", c);
		if(c.size()>0) {
		map.put("cartlist",c);
		LOGGER.info("End");
		return "cart";
		}
		else
			return "cart-empty";
	}
		
	
}
