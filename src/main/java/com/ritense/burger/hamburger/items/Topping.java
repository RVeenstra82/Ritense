package com.ritense.burger.hamburger.items;

public enum Topping {
	CHEESE( "Cheese" ), 
	SAUCES( "Sauces" ), 
	LETTUCE( "Lettuce" ), 
	TOMATO( "Tomato"), 
	ONION( "Onion" ),
	PICKLE( "Pickle" );

	private String toppingName;
	
	Topping(String toppingName) {
		this.toppingName = toppingName;
	}

	public String toString() {
		return toppingName;
	}
}
