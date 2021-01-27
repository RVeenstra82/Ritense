package com.ritense.burger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ritense.burger.exception.MaxToppingsException;
import com.ritense.burger.hamburger.BasicBurger;
import com.ritense.burger.hamburger.Hamburger;
import com.ritense.burger.hamburger.HealthyBurger;
import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;
import com.ritense.burger.hamburger.items.Topping;
import com.ritense.burger.tools.BurgerPrice;

class BurgerPriceTest {

	@Test
	void getPricesFullHealthyBurger() throws MaxToppingsException {
		// Create a healthy burger
		Hamburger burger = new HealthyBurger(BreadTypes.BRIOCHE, Meat.FISH_PATTY);
		// Add the maximum amount of toppings
		burger.addTopping(Topping.CHEESE);
		burger.addTopping(Topping.LETTUCE);
		burger.addTopping(Topping.ONION);
		burger.addTopping(Topping.PICKLE);
		burger.addTopping(Topping.SAUCES);
		burger.addTopping(Topping.TOMATO);

		// Check the prices
		assertEquals(3.00, BurgerPrice.calculateToppings(burger));
		assertEquals(0, BurgerPrice.calculateAdditions(burger));
		assertEquals(7.49, BurgerPrice.calculateTotal(burger));
	}
	
	@Test
	void getPricesBasicBurger() throws MaxToppingsException {
		// Create a healthy burger
		Hamburger burger = new BasicBurger(BreadTypes.WHITE, Meat.KOBY_BEEF_PATTY);
		// Add the a couple of toppings
		burger.addTopping(Topping.CHEESE);
		burger.addTopping(Topping.SAUCES);
		burger.addTopping(Topping.LETTUCE);

		// Check the prices
		assertEquals(1.50, BurgerPrice.calculateToppings(burger));
		assertEquals(0, BurgerPrice.calculateAdditions(burger));
		assertEquals(6.49, BurgerPrice.calculateTotal(burger));
	}
	
	@Test
	void getPricesComboBurger() throws MaxToppingsException {
		// Create a healthy burger
		Hamburger burger = new BasicBurger(BreadTypes.WHITE, Meat.KOBY_BEEF_PATTY);
		
		// Add additions
		

		// Check the prices
		assertEquals(0, BurgerPrice.calculateToppings(burger));
		assertEquals(0, BurgerPrice.calculateAdditions(burger));
		assertEquals(4.99, BurgerPrice.calculateTotal(burger));
	}

}
