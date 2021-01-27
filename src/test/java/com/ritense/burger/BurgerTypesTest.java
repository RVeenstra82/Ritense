package com.ritense.burger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ritense.burger.exception.MaxToppingsException;
import com.ritense.burger.hamburger.BasicBurger;
import com.ritense.burger.hamburger.ComboBurger;
import com.ritense.burger.hamburger.Hamburger;
import com.ritense.burger.hamburger.HealthyBurger;
import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;
import com.ritense.burger.hamburger.items.Topping;

class BurgerTypesTest {

	@Test
	void makeBaseBurger() {
		Hamburger burger = new BasicBurger( BreadTypes.WHOLEGRAIN, Meat.BLACK_ANGUS_PATTY );
		assertNotNull( burger );
		assertEquals( 4.99, burger.getBasicPrice() );
	}

	@Test
	void makeHealthyBurger() {
		Hamburger burger = new HealthyBurger( BreadTypes.CIABATTA, Meat.VEGAN_PATTY );
		assertNotNull( burger );
		assertEquals( 5.99, burger.getBasicPrice() );
	}
	
	@Test
	void makeComboBurger() {
		Hamburger burger = new ComboBurger( BreadTypes.WHITE, Meat.KOBY_BEEF_PATTY );
		assertNotNull( burger );
		assertEquals( 7.49, burger.getBasicPrice() );
	}
	
	@Test
	void toManyToppingComboBurger() throws MaxToppingsException {
		Hamburger burger = new ComboBurger(BreadTypes.BRIOCHE, Meat.FISH_PATTY);
		// Adding 1 topping, should result in a throw of the MaxToppingsException
		assertThrows(MaxToppingsException.class, () -> {
			burger.addTopping( Topping.SAUCES );
		});
	}
	
	@Test
	void toManyToppingBasicBurger() throws MaxToppingsException {
		Hamburger burger = new BasicBurger( BreadTypes.WHOLEGRAIN, Meat.BLACK_ANGUS_PATTY );
		// Adding 4 toppings
		burger.addTopping(Topping.CHEESE);
		burger.addTopping(Topping.LETTUCE);
		burger.addTopping(Topping.ONION);
		burger.addTopping(Topping.PICKLE);
		
		// Adding 1 extra topping, should result in a throw of the MaxToppingsException
		assertThrows(MaxToppingsException.class, () -> {
			burger.addTopping( Topping.SAUCES );
		});
	}

}
