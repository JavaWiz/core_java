package com.javawiz.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		          	                     
		Employee emp1 = new Employee("John", 25, 3000.00, 9922001);
		Employee emp2 = new Employee("Ace", 45, 2000.00, 5924001);
		Employee emp3 = new Employee("Keith", 35, 4000.00, 3924401);
		
		Employee[]	employees = new Employee[] {emp1, emp2, emp3};
		whenComparing_UsingLambda_thenSorted(Arrays.asList(employees));
		whenComparing_UsingComparatorComparing_thenSorted(Arrays.asList(employees));
	}
	
	public static void whenComparing_UsingLambda_thenSorted(List<Employee> employees) {
        System.out.println("************** Java 8 Comaparator **************");
        Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Comparator<Employee> byAge = (e1, e2) -> e1.getAge()- e2.getAge();
        
        System.out.println("Before Sorting :");
        employees.forEach(System.out::println);
        
        System.out.println("************** Sort byName **************");
        Collections.sort(employees, byName);
        System.out.println("After Sorting : ");
        employees.forEach(System.out::println);
        System.out.println("*****************************************");
        
        System.out.println("************** Sort byAge ***************");
        Collections.sort(employees, byAge);
        System.out.println("After Sorting by age : ");
        employees.forEach(System.out::println);
        System.out.println("*****************************************");
	}
	
	public static void whenComparing_UsingComparatorComparing_thenSorted(List<Employee> employees) {
        System.out.println("********* Comaparator.comparing method *********");
        Comparator<Employee> byName = Comparator.comparing(Employee::getName);
        Comparator<Employee> byAge = Comparator.comparing(Employee::getAge);
        
        System.out.println("************** Sort byName **************");
        System.out.println("Before Sorting :");
        employees.forEach(System.out::println);
        Collections.sort(employees, byName);
        System.out.println("After Sorting : ");
        employees.forEach(System.out::println);
        System.out.println("*****************************************");
        System.out.println("************** Sort byAge ***************");
        Collections.sort(employees, byAge);
        System.out.println("After Sorting : ");
        employees.forEach(System.out::println);
        System.out.println("*****************************************");
    }
	
	public void print(List<Employee> employees) {
		employees.forEach(System.out::println);
	}
}
