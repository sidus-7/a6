/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: BevShopDriverApp, the driver class for this project
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

import java.util.Scanner;

public class BevShopDriverApp {

	public static void main(String[] args) {
		
		BevShop myStore = new BevShop();
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean stillOrdering = false;

		
		System.out.print("Welcome to the new BevShop! Would you like to order? (y/n) ");
		String user = keyboard.nextLine();
		do {
			if(user.equals("y") || user.equals("Y")){
				System.out.println("Great! Let's get started. The current order in process can have at most 3 alcoholic beverages."
						+ "\nThe minimum age to order alcohol drink is 21\nAge: ");
				
				int age = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.println("Name: ");
				String cus1Name = keyboard.nextLine();
				
				
		
				myStore.startNewOrder(10, Day.THURSDAY, cus1Name, age);
				
				String drink, size;
				
				System.out.println("What drink do you want?: ");
				
				drink = keyboard.nextLine();
				
				System.out.println("What size?: ");
				
				size = keyboard.nextLine();
				
				if(drink == "c") {
					if(size == "s") {
						myStore.processCoffeeOrder("Coffee", Size.SMALL, false, false);
					}else if(size == "m") {
						myStore.processCoffeeOrder("Coffee", Size.MEDIUM, false, false);
					}else if(size == "l") {
						myStore.processCoffeeOrder("Coffee", Size.LARGE, false, false);
					}
				}else if(drink == "s") {
					if(size == "s") {
						myStore.processSmoothieOrder("Smoothie", Size.SMALL, 0, true);
					}else if(size == "m") {
						myStore.processSmoothieOrder("Smoothie", Size.MEDIUM, 0, true);
					}else if(size == "l") {
						myStore.processSmoothieOrder("Smoothie", Size.LARGE, 0, false);
					}
					
				}else if(drink == "a") {
					if(size == "s") {
						myStore.processAlcoholOrder("Bubbly drink", Size.SMALL);
					}else if(size == "m") {
						myStore.processAlcoholOrder("Bubbly drink", Size.MEDIUM);
					}else if(size == "l") {
						myStore.processAlcoholOrder("Bubbly drink", Size.LARGE);
					}
					
				}
				
				
				double totalCost = myStore.getCurrentOrder().calcOrderTotal();
				
				System.out.println("Total cost of order is: " + totalCost);
				
				System.out.println("Do you want to continue your order (y/n): ");
				String contOrder = keyboard.nextLine();
				
				stillOrdering = true ? contOrder == "y": false;
				
			}
			else if(user.equals("n") || user.equals("N")) break;
		}
		while(stillOrdering);
		
		System.out.print("Thanks for visiting!\n\nMichael Chance\tCMSC203");
        
        
		keyboard.close();
		
	}
}
