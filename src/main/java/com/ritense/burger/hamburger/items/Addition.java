package com.ritense.burger.hamburger.items;

public enum Addition {
	COCA_COLA( "Coka Cola" ),
	FANTA( "Fanta" ),
	CHIPS( "Chips" ),;

	private String additionName;

	Addition(String additionName) {
		this.additionName = additionName;
	}
	
	public String toString() {
		return additionName;
	}
}
