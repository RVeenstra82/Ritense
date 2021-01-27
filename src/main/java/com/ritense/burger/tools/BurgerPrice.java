package com.ritense.burger.tools;

import com.ritense.burger.hamburger.Hamburger;

public class BurgerPrice {
	public static final double PRICE_PER_TOPPING = 0.50;
	public static final double PRICE_PER_ADDITION = 1.60;
			
	
	public static double calculateToppings( Hamburger burger ) {
		return PRICE_PER_TOPPING * burger.getAmountOfToppings();
	}

	public static double calculateAdditions(Hamburger burger) {
		return PRICE_PER_ADDITION * burger.getAmountOfAdditions();
	}

	/**
	 * This method will calculate the total value for the burger
	 * @param burger
	 * @return
	 */
	public static double calculateTotal( Hamburger burger ) {
		return burger.getBasicPrice() + calculateToppings( burger ) + calculateAdditions( burger );
	}
}
