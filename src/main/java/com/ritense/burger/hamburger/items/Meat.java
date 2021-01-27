package com.ritense.burger.hamburger.items;

/**
 * The different type of meats 
 */
public enum Meat {
	BLACK_ANGUS_PATTY( "Black Angus Patty"), 
	KOBY_BEEF_PATTY("Koby Beef Patty"), 
	VEGAN_PATTY("Vegan Patty"), 
	FISH_PATTY("Fish Patty");
	
	private String meatName;
	
	Meat(String meatName) {
		this.meatName = meatName;
	}

	public String toString() {
		return meatName;
	}
}
