package com.ritense.burger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ritense.burger.hamburger.items.Addition;
import com.ritense.burger.hamburger.items.Topping;

@Service
public class BurgerService implements IBurgerService {

	@Override
	public List<String> getBurgerTypes() {
		return Arrays.asList( "Basic Burger","Healthy Burger", "Combo Burger");
	}

	@Override
	public List<Topping> getToppings() {
		return null;
	}

	@Override
	public void addTopping(Topping extraTopping) {

	}

	@Override
	public List<Addition> getAddition() {
		return null;
	}

	@Override
	public void addAddition(Addition extraAddition) {

	}

	@Override
	public String getTotalPrice() {
		return null;
	}

}
