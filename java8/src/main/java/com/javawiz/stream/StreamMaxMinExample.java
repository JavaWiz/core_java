package com.javawiz.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;
import com.javawiz.model.Person;

public class StreamMaxMinExample {
	public static void main(String[] args) {
		Optional<Person> maxWeightPerson = CollectionDB.getAllPersons().stream().max(Comparator.comparing(Person::getWeight));
		
		System.out.println("Person with max weight : " + maxWeightPerson.get());
		
		Optional<Person> minWeightPerson = CollectionDB.getAllPersons().stream().min(Comparator.comparing(Person::getWeight));
		
		System.out.println("Person with min weight : " + minWeightPerson.get());
		
		List<Employee> employeeList = CollectionDB.getEmployees();

		Optional<Employee> maxSalaryEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
		
		System.out.println(
				"Employee with max salary :" + (maxSalaryEmp.isPresent() ? maxSalaryEmp.get() : "Not Applicable"));
		
		Optional<Employee> minAgeEmp = employeeList.stream().min(Comparator.comparing(Employee::getAge));
		
		System.out.println("Employee with min age :" + (minAgeEmp.isPresent() ? minAgeEmp.get() : "Not Applicable"));
		
		Predicate<Employee> salP = e -> e.getSalary() > 20000;
		employeeList.stream().filter(salP)
				.min(Comparator.comparing(Employee::getAge))
				.ifPresent(System.out::println);
		// Select emp  from employee where 
	}
}