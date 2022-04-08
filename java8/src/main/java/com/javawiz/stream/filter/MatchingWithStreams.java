package com.javawiz.stream.filter;

import java.util.Arrays;
import java.util.List;

public class MatchingWithStreams {
	static List<Employee> employeeList = Arrays.asList(
			new Employee("Tom Jones", 45), 
			new Employee("Harry Major", 25),
			new Employee("Ethan Hardy", 65), 
			new Employee("Nancy Smith", 22), 
			new Employee("Deborah Sprightly", 29));

	public static void main(String[] args) {
		allMatch();
		anyMatch();
		nonMatch();
	}
	
	public static void allMatch() {
		boolean allEmpAbove21 = employeeList.stream().allMatch(emp -> emp.getAge() > 21);
		System.out.println("All employees are above 21:" + allEmpAbove21);
	}
	
	public static void anyMatch() {
		boolean empAbove40 = employeeList.stream()
                .anyMatch(emp -> emp.getAge() > 40);
		System.out.println("Any employee is above 40:" + empAbove40);
	}
	
	public static void nonMatch() {
		boolean noEmpBelow30 = employeeList.stream()
                .noneMatch(emp -> emp.getAge() < 30);
		System.out.println("No employee is below 30:" + noEmpBelow30);
	}
}

