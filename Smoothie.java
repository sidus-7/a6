/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Smoothie that extends Beverage
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

public class Smoothie extends Beverage {
    private int numberOfFruits;
    private boolean proteinAdded;

    public Smoothie(String bevName, Size size, int numberOfFruits, boolean proteinAdded) {
        super(bevName, Type.SMOOTHIE, size);
        this.numberOfFruits = numberOfFruits;
        this.proteinAdded = proteinAdded;
    }

    @Override
    public double calcPrice() {
        double price = getBASE_PRICE();
        if (getSize() == Size.MEDIUM) {
            price += getSIZE_PRICE();
        } else if (getSize() == Size.LARGE) {
            price += getSIZE_PRICE() * 2;
        }
        if (proteinAdded) {
            price += 1.5;
        }
        price += 0.5 * numberOfFruits;
        return price;
    }

    @Override
    public String toString() {
        return "Smoothie: " + super.toString() +
                ", numberOfFruits= " + numberOfFruits +
                ", proteinAdded= " + proteinAdded +
                ", price= " + calcPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smoothie)) return false;
        if (!super.equals(o)) return false;
        Smoothie smoothie = (Smoothie) o;
        return numberOfFruits == smoothie.numberOfFruits &&
                proteinAdded == smoothie.proteinAdded;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    public boolean isProteinAdded() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }
}
