package com.ritense.burger.hamburger.items;

public enum BreadTypes {
	WHOLEGRAIN( "Wholegrain"), 
	WHITE( "White" ), 
	BRIOCHE( "Brioche"),
	CIABATTA( "Ciabatta" );

	private String breadName;
	
	BreadTypes(String breadName) {
		this.breadName = breadName;
	}
	
	public String toString() {
		return breadName;
	}
}
