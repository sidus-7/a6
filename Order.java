/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Order, implements OrderInterface and Comparable
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

import java.util.ArrayList;
import java.util.Random;


public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
	
	
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    public int getOrderNo() {
		return orderNumber;
	}
    
    // Generate random order number
    private int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(80001) + 10000;
    }
	

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
        return new Customer(customer.getName(), customer.getAge());
    }
	
	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) return true;
		else return false;
	}
	
	@Override
	public Beverage getBeverage(int itemNo) {
        if (itemNo < 0 || itemNo >= beverages.size()) {
            return null; // Invalid itemNo
        }
        return beverages.get(itemNo);
    }

	@Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
        
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
    	beverages.add(new Alcohol(bevName, size, this.isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }
    
    public int getTotalItems() {
        return beverages.size();
    }

    // Calculate total amount for this order
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    // Find number of beverages of same type in an order
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Customer Age: ").append(customer.getAge()).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage).append("\n");
        }
        return sb.toString();
    }

    // Override compareTo method
    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(this.orderNumber, otherOrder.orderNumber);
    }



}
