package com.javawiz.lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BeforeJava8 {

    public static void main(String[] args) {

    	List<Person> persons = Arrays.asList(
                new Person("Ranjan", "Sai", 35),
                new Person("Rejina", "Patel", 30),
                new Person("Rehanshi", "Sai", 2),
                new Person("Aswini", "Naik", 45));
    	
    	// Sort list by last name and print it
    	Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
    	
    	for (Person person : persons) {
			System.out.println(person);
		}
    	
    	//Filter by first name begin with A
    	getPersonByLastNameConditionally(persons, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getFirstName().startsWith("A");
			}
		});
    	
    	//Filter by first name begin with R
    	getPersonByLastNameConditionally(persons, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getFirstName().startsWith("R");
			}
		});
    }
    
    private static void getPersonByLastNameConditionally(List<Person> persons, Condition condition) {
		for (Person person : persons) {
    		if(condition.test(person)) {
    			System.out.println(person);
    		}
    	}
	}
}
