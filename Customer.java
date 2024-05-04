/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Class called Customer
 * Due: 05/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael Chance
*/

public class Customer {
	private String name;
	private int age;
	
	// Constructors
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [name= " + name + ", age= " + age + "]";
	}
	
	
}
