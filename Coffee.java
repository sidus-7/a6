/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Coffee that extends Beverage
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
        
    }

    @Override
    public double calcPrice() {
        double price = getBASE_PRICE();
        if (getSize() == Size.MEDIUM) {
            price += getSIZE_PRICE();
        } else if (getSize() == Size.LARGE) {
            price += getSIZE_PRICE() * 2;
        }
        if (extraShot) {
            price += 0.5;
        }
        if (extraSyrup) {
            price += 0.5;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Coffee: " + super.toString() +
                ", extraShot= " + extraShot +
                ", extraSyrup= " + extraSyrup +
                ", price= " + calcPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        if (!super.equals(o)) return false;
        Coffee coffee = (Coffee) o;
        return extraShot == coffee.extraShot &&
                extraSyrup == coffee.extraSyrup;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
