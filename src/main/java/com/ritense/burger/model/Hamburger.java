package com.ritense.burger.model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

import com.ritense.burger.exception.MaxToppingsException;
import com.ritense.burger.hamburger.items.Addition;
import com.ritense.burger.hamburger.items.BreadTypes;
import com.ritense.burger.hamburger.items.Meat;
import com.ritense.burger.hamburger.items.Topping;
import com.ritense.burger.tools.BurgerPrice;

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

	private static DecimalFormat df = new DecimalFormat("0.00");
	
	private BreadTypes bread;
	private Meat meat;
	private EnumSet<Topping> toppings;
	private EnumSet<Addition> additions;
	
	public Hamburger(BreadTypes bread, Meat meat ) {
		toppings = EnumSet.noneOf(Topping.class);
		additions = EnumSet.noneOf(Addition.class);
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

	public double getAmountOfToppings() {
		return toppings.size();
	}

	
	public void addAddition(Addition newAddition) {
		additions.add( newAddition );
	}

	public double getAmountOfAdditions() {
		return additions.size();
	}

	public double getTotalPrice() {
		return BurgerPrice.calculateTotal( this ); 
	}
	
	/**
	 * Confience method that will either return a comma seperated String of chosen toppings or (when none is added) return the text None
	 * @return
	 */
	private String getToppingString() {
		if ( toppings.size() == 0 ) {
			return "None";
		}
		
		return Arrays.stream(toppings.toArray())
				.map( t -> t.toString())
				.collect(Collectors.joining(","));
	}
	
	/**
	 * Confience method that will either return a comma seperated String of chosen additions or (when none is added) return the text None
	 * @return
	 */
	private String getAdditionstring() {
		if ( additions.size() == 0 ) {
			return "None";
		}
		
		return Arrays.stream(additions.toArray())
				.map( a -> a.toString())
				.collect(Collectors.joining(","));
	}
	
	/**
	 * This will output the following
	 *  - The basic price of the Hamburger
	 *  - A list of chosen topics and what it will cost
	 *  - A list of chosen additions and what it will cost
	 *  - A total price for the burger
	 */
	@Override
	public String toString() {
		return "Hamburger:\t €" + df.format(getBasicPrice())
		+ "\nToppings:\t " + getToppingString()
		+ "\n\t + €" + df.format(BurgerPrice.calculateToppings(this))
		+ "\nAdditions:\t " + getAdditionstring()
		+ "\n\t + €" + df.format(BurgerPrice.calculateAdditions(this))
		+ "\nTotal price:\t €" + df.format(getTotalPrice());
	}
}