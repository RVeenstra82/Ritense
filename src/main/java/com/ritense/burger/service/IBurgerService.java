package com.ritense.burger.service;

import java.util.List;

import com.ritense.burger.hamburger.items.Addition;
import com.ritense.burger.hamburger.items.Topping;

public interface IBurgerService {
	List<String> getBurgerTypes();
	
	List<Topping> getToppings();
	void addTopping( Topping extraTopping );
	
	List<Addition> getAddition();
	void addAddition( Addition extraAddition );
	
	String getTotalPrice();
}