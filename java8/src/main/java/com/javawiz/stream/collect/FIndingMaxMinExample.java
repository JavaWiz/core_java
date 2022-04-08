package com.javawiz.stream.collect;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;
import com.javawiz.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FIndingMaxMinExample {
	public static void main(String[] args) {
		Optional<Person> maxWeightPerson = CollectionDB.getAllPersons().stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getWeight)));
		
		System.out.println("Person with max weight : " + maxWeightPerson.get());
		
		Optional<Person> minWeightPerson = CollectionDB.getAllPersons().stream()
				.collect(Collectors.minBy(Comparator.comparing(Person::getWeight)));
		
		System.out.println("Person with min weight : " + minWeightPerson.get());
		
		List<Employee> employeeList = CollectionDB.getEmployees();

		Optional<Employee> maxSalaryEmp = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		
		System.out.println(
				"Employee with max salary :" + (maxSalaryEmp.isPresent() ? maxSalaryEmp.get() : "Not Applicable"));
		
		Optional<Employee> minAgeEmp = employeeList.stream()
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
		
		System.out.println("Employee with min age :" + (minAgeEmp.isPresent() ? minAgeEmp.get() : "Not Applicable"));
	}

}
