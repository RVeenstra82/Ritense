package com.ritense.burger.model;

import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;

public class HealthyBurger extends Hamburger {

	public HealthyBurger(BreadTypes bread, Meat meat) {
		super(bread, meat);
	}

	@Override
	protected int getMaxToppings() {
		return 6;
	}

	@Override
	public double getBasicPrice() {
		return 4.49;
	}

}
