package com.cognizant.truyumm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyumm.TruyummApplication;
import com.cognizant.truyumm.model.Menu;
import com.cognizant.truyumm.repository.MenuRepository;

@Controller
public class MenuItemController {

	@Autowired
	MenuRepository usersRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyummApplication.class);

	@RequestMapping("/menu-item-list-admin")
	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("Start");
		/*
		 * Menu m=new Menu(); m.setId(1); m.setName("Chocolate Brownie");
		 * m.setPrice(57.0f); m.setActive("Yes"); m.setDateoflaunch("02/11/2017");
		 * m.setCategory("Desert"); m.setFreedelivery("Yes"); usersRepository.save(m);
		 */

		List<Menu> menu = (List<Menu>) usersRepository.findAll();
		LOGGER.debug("MenuAdmin={}", menu);
		model.put("menulist", menu);
		// System.out.println("hello"+menu);
		LOGGER.info("End");
		return "menu-item-list-admin";

	}

	@RequestMapping("/edit-menu-item")
	public String EditMenuItemListAdmin(ModelMap model, @RequestParam Integer id) {
		LOGGER.info("Start");

		List<Menu> menu = (List<Menu>) usersRepository.findAll();
		Menu men = new Menu();
		for (Menu m : menu) {
			if (m.getId() == id) {
				men.setId(id);
				men.setName(m.getName());
				men.setPrice(m.getPrice());
				men.setActive(m.getActive());
				men.setDateoflaunch(m.getDateoflaunch());
				men.setCategory(m.getCategory());
				men.setFreedelivery(m.getFreedelivery());
			}
		}
		model.put("menu", men);

		LOGGER.info("End");
		return "edit-menu-item";

	}

	@RequestMapping("/edit-menu-item-status")
	public String UpdateMenuItemList(ModelMap model, @RequestParam Integer id, @RequestParam String title,
			@RequestParam float price, @RequestParam String inStock, @RequestParam String dateOfLaunch,
			@RequestParam String category, @RequestParam(defaultValue = "false") String freeDelivery) {

		LOGGER.info("Start");

		Menu m = new Menu();
		m.setId(id);
		m.setName(title);
		m.setPrice(price);

		m.setActive(inStock);
		m.setDateoflaunch(dateOfLaunch);
		m.setCategory(category);
		if (freeDelivery.equals("on"))
			freeDelivery = "Yes";
		else
			freeDelivery = "No";
		m.setFreedelivery(freeDelivery);
		System.out.println(id + " " + title + " " + price + " " + inStock + " " + dateOfLaunch + " " + category + " "
				+ freeDelivery);
		usersRepository.save(m);
		List<Menu> menu = (List<Menu>) usersRepository.findAll();
		model.put("menulist", menu);
		LOGGER.info("End");
		return "edit-menu-item-status";

	}

}
