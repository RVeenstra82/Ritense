package com.ritense.burger.hamburger;

import java.util.EnumSet;

import com.ritense.burger.exception.MaxToppingsException;
import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;
import com.ritense.burger.hamburger.items.Topping;

/**
 * All the Hamburger should extend from this class
 * 
 * This class will handle the bread, meat and toppings and will be able to output the following
 *  - Base price of the hamburger
 *  - Each topping name
 *  - Price of the toppings
 *  - A total price ( base prices + all toppings / additions )
 */
public abstract class Hamburger {
	private BreadTypes bread;
	private Meat meat;
	private EnumSet<Topping> toppings;
	
	public Hamburger(BreadTypes bread, Meat meat ) {
		toppings = EnumSet.noneOf(Topping.class);
		this.bread = bread;
		this.meat = meat;
	}
	
	protected abstract int getMaxToppings();
	public abstract double getBasicPrice();
	
	public Meat getMeat() {
		return meat;
	}
	
	public BreadTypes getBread() {
		return bread;
	}

	/**
	 * Add a single extra topping to the Hamburger 
	 * 
	 * @param newTopping
	 * @throws MaxToppingsException - Thrown when the next topping will be more then the allowed amount
	 */
	public void addTopping( Topping newTopping ) throws MaxToppingsException {
		if ( toppings.size() + 1 > getMaxToppings() ) {
			throw new MaxToppingsException();
		}
		
		toppings.add( newTopping );
	}
}
