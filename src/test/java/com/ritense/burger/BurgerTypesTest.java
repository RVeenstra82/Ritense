package com.ritense.burger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ritense.burger.exception.MaxToppingsException;
import com.ritense.burger.hamburger.items.Addition;
import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;
import com.ritense.burger.hamburger.items.Topping;
import com.ritense.burger.model.BasicBurger;
import com.ritense.burger.model.ComboBurger;
import com.ritense.burger.model.Hamburger;
import com.ritense.burger.model.HealthyBurger;

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
		assertEquals( 4.49, burger.getBasicPrice() );
		
	}
	
	@Test
	void makeComboBurger() {
		Hamburger burger = new ComboBurger( BreadTypes.WHITE, Meat.KOBY_BEEF_PATTY );
		assertNotNull( burger );
		assertEquals( 3.49, burger.getBasicPrice() );
	}
	
	@Test
	void makeComboBurgerWithAdditions() {
		Hamburger burger = new ComboBurger(BreadTypes.BRIOCHE, Meat.FISH_PATTY);
		assertNotNull( burger );
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
	
	@Test
	void testToStringBasicBurger() throws MaxToppingsException {
		Hamburger burger = new BasicBurger( BreadTypes.WHOLEGRAIN, Meat.BLACK_ANGUS_PATTY );
		// Adding 4 toppings
		burger.addTopping(Topping.CHEESE);
		burger.addTopping(Topping.LETTUCE);
		burger.addTopping(Topping.ONION);
		burger.addTopping(Topping.PICKLE);
		
		// Remove all the new line and tabs from the output message
		String cleanString = burger.toString().replaceAll("\n", "").replaceAll("\t", "");
		assertEquals("Hamburger: €4,99Toppings: Cheese,Lettuce,Onion,Pickle + €2,00Additions: None + €0,00Total price: €6,99", cleanString );
	}
	
	@Test
	void testToStringComboBurger() throws MaxToppingsException {
		Hamburger burger = new BasicBurger( BreadTypes.WHOLEGRAIN, Meat.BLACK_ANGUS_PATTY );
		// Add additions
		burger.addAddition(Addition.COCA_COLA);
		
		// Remove all the new line and tabs from the output message
		String cleanString = burger.toString().replaceAll("\n", "").replaceAll("\t", "");
		assertEquals("Hamburger: €4,99Toppings: None + €0,00Additions: Coka Cola + €1,60Total price: €6,59", cleanString );
	}

}
