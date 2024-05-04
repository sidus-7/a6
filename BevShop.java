/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called BevShop, implements BevShopInterface
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {

    private int numOfAlcoholDrinks;
    private ArrayList<Order> orders;

    public BevShop() {
        this.numOfAlcoholDrinks = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order order = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(order);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        // Add the Coffee object to the current order
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
    	getCurrentOrder().addNewBeverage(bevName, size);
    	numOfAlcoholDrinks++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
    	getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
    	for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderNo() == orderNo) {
                return i; // Return the index of the matching order
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        for(Order order: orders) {
        	if(order.getOrderNo() == orderNo) {
        		return order.calcOrderTotal();
        	}
        }
        return 0.0;
    }


    @Override
    public double totalMonthlySale() {
        double totalSale = 0.0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return orders.isEmpty() ? null : orders.get(orders.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
    	int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Swap orders
                Order temp = orders.get(i);
                orders.set(i, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: $").append(totalMonthlySale());
        return sb.toString();
    }
}

