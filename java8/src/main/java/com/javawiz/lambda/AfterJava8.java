package com.javawiz.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AfterJava8 {

    public static void main(String[] args) {

    	List<Person> persons = Arrays.asList(
                new Person("Ranjan", "Sai", 35),
                new Person("Rejina", "Patel", 30),
                new Person("Rehanshi", "Sai", 2),
                new Person("Aswini", "Naik", 45));
    	
    	// Sort list by last name and print it
    	persons.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		persons.forEach(System.out::println);

    	System.out.println("================================================");
    	
    	//Filter by first name begin with A
    	getPersonConditionally(persons, person -> person.getFirstName().startsWith("A"));
    	
    	System.out.println("================================================");
    	
    	//Filter by first name begin with R
    	getPersonConditionally(persons, person -> person.getLastName().startsWith("S"));
    }

	private static void getPersonConditionally(List<Person> persons, Condition condition) {
		for (Person person : persons) {
    		if(condition.test(person)) {
    			System.out.println(person);
    		}
    	}
	}
}
