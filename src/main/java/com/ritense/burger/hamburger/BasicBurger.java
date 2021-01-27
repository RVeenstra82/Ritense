package com.ritense.burger.hamburger;

import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;

public class BasicBurger extends Hamburger {
	public BasicBurger( BreadTypes bread, Meat meat ) {
		super(bread, meat);
	}

	@Override
	protected int getMaxToppings() {
		return 4;		
	}

	@Override
	public double getBasicPrice() {
		return 4.99;
	}
}
