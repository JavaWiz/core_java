package com.javawiz.stream.scenarios;

import java.util.List;
import java.util.stream.Collectors;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

public class Java8ScenarioExample {

	public static void main(String[] args) {
		
		//give a list with those employees with salaries below 80,000 and update their salaries with a 5% increase.
		List<Employee> list = CollectionDB.getEmployees();
		System.out.println(list);
		
		List<Employee> modifiedList =
				list.stream()
				.filter(employee -> {
					System.out.println("Filtered Employee Name: "+employee.getName());
					return employee.getSalary() < 25000;
				})
		.map(emp ->{
			System.out.println("Mapped Employee Name: "+emp.getName());
			return new Employee(emp.getId(), emp.getName(), emp.getAge(), emp.getSalary() + (emp.getSalary() * .05), emp.getPhoneNumbers());
		})
		.collect(Collectors.toList());
		
		System.out.println(modifiedList);
	}
}