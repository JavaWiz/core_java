package com.javawiz.stream.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Requirement
 * We have a method to get all the employees data.
 * Now we want to pass employees data to HR system but we don't want to disclose the salary.
 * So we will have to use below code to process each employee and remove their salary.
 */
public class ThirdExample {

	public static void main(String[] args) {
		List<Employee> allEmpList = new ArrayList<>();
		Employee e1 = new Employee(1, "Ranjan", 20000, "Programmer");
		Employee e2 = new Employee(2, "Rejina", 21000, "Tester");
		Employee e3 = new Employee(3, "Rabina", 22000, "Analyst");
		Employee e4 = new Employee(4, "Rehanshi", 23000, "Manager");

		allEmpList.add(e1);
		allEmpList.add(e2);
		allEmpList.add(e3);
		allEmpList.add(e4);

		beforeJava8(allEmpList);
		inJava8(allEmpList);
	}

	private static void inJava8(List<Employee> allEmpList) {
		List<Employee> empForHR = allEmpList.stream().map(e -> { e.setSalary(0); return e;}).collect(Collectors.toList());
		System.out.println(empForHR);
	}

	private static void beforeJava8(List<Employee> allEmpList) {
		List<Employee> empForHR = new ArrayList<>();
		for (Employee e : allEmpList) {
			Employee temp = new Employee(e.getId(), e.getName(), e.getSalary(), e.getDesignation());
			temp.setSalary(0);
			empForHR.add(temp);
		}
		System.out.println(empForHR);
	}
}
