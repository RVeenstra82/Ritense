package com.ritense.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ritense.burger.service.IBurgerService;


@Controller
public class BurgerController {
	
	@Autowired
	private IBurgerService service;
	
	@RequestMapping(value = "/list-burgertypes", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		
		model.put("burgerTypes", service.getBurgerTypes());
		return "list-burgertypes";
	}
	
	@RequestMapping("/add-burger")
	public String addBurger(@RequestParam String name, ModelMap model ) {
		model.put("burgerName", name);
		return "add-burger";
	}	
}
