/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Alcohol that extends Beverage
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

public class Alcohol extends Beverage{
	private boolean weekendOffer;

    public Alcohol(String bevName, Size size, boolean weekendOffer) {
        super(bevName, Type.ALCOHOL, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public double calcPrice() {
        double price = getBASE_PRICE();
        if (getSize() == Size.MEDIUM) {
            price += getSIZE_PRICE();
        } else if (getSize() == Size.LARGE) {
            price += getSIZE_PRICE() * 2;
        }
        if (weekendOffer) {
            price += 0.6;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Alcohol: " + super.toString() +
                ", weekendOffer= " + weekendOffer +
                ", price= " + calcPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alcohol)) return false;
        if (!super.equals(o)) return false;
        Alcohol alcohol = (Alcohol) o;
        return weekendOffer == alcohol.weekendOffer;
    }

    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }

    
}
