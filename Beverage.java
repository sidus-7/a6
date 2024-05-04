/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Beverage
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

import java.util.Objects;

/**
 * Abstract class representing a beverage.
 */
public abstract class Beverage {

    /** The name of the beverage. */
    private String bevName;

    /** The type of the beverage. */
    private Type type;

    /** The size of the beverage. */
    private Size size;

    /** The base price of the beverage. */
    private final double BASE_PRICE = 2.0;

    /** The additional price for different sizes. */
    private final double SIZE_PRICE = 0.5;

    /**
     * Constructs a beverage with the specified name, type, and size.
     *
     * @param bevName the name of the beverage
     * @param type the type of the beverage
     * @param size the size of the beverage
     */
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    /**
     * Abstract method to calculate the price of the beverage.
     *
     * @return the price of the beverage
     */
    public abstract double calcPrice();

    /**
     * Adds the size price to the base price based on the size of the beverage.
     *
     * @return the total price of the beverage including size
     */
    public double addSizePrice() {
        if (size == Size.SMALL) {
            return BASE_PRICE; // No additional cost for small size
        } else if (size == Size.MEDIUM) {
            return BASE_PRICE + SIZE_PRICE; // Add size price for medium
        } else {
            return BASE_PRICE + 2 * SIZE_PRICE; // Add size price for large
        }
    }

    // Getters

    /**
     * Returns the name of the beverage.
     *
     * @return the name of the beverage
     */
    public String getBevName() {
        return bevName;
    }

    /**
     * Returns the type of the beverage.
     *
     * @return the type of the beverage
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the size of the beverage.
     *
     * @return the size of the beverage
     */
    public Size getSize() {
        return size;
    }

    /**
     * Returns the base price of the beverage.
     *
     * @return the base price of the beverage
     */
    public double getBASE_PRICE() {
        return BASE_PRICE;
    }

    /**
     * Returns the size price of the beverage.
     *
     * @return the size price of the beverage
     */
    public double getSIZE_PRICE() {
        return SIZE_PRICE;
    }

    // Override methods

    /**
     * Returns a string representation of the beverage.
     *
     * @return a string representation of the beverage
     */
    @Override
    public String toString() {
        return "Beverage [name= " + bevName + ", size= " + size + "]";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return Objects.equals(bevName, beverage.bevName) &&
               type == beverage.type &&
               size == beverage.size;
    }
}

