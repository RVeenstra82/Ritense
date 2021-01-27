package com.ritense.burger.hamburger;

import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;

public class ComboBurger extends Hamburger {
	public ComboBurger( BreadTypes bread, Meat meat ) {
		super( bread, meat);
	}
	
	@Override
	public double getBasicPrice() {
		return 3.49;
	}

	@Override
	protected int getMaxToppings() {
		return 0;
	}
}
