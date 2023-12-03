package com.javawiz.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

public class GroupingByExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", "D", "A");
		
		//We can use the groupingBy method to manage aggregation, for example:
	    Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(Function.identity()));
	    System.out.println(map);
	    
	    System.out.println("==== grouping by their name and mapped to list of id ====");
	    List<Employee> emps = new ArrayList<>(CollectionDB.getEmployees());
		emps.add(new Employee(6, "Ranjan", 36, 42000.00, Arrays.asList("312-476-8686", "312-224-7575")));
		
		//If you want more flexibility (for example to map the value and return a Set instead of a List) 
	    //we can always use the groupingBy method with more parameters as specified in java doc:
		Map<String, List<Integer>> map1 = emps.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.mapping(Employee::getId, Collectors.toList())));
		System.out.println(map1);
		
		System.out.println("====================grouping by their name and listed details ===========================");
		Function<Employee, Employee> mapper = employee -> employee;
		Map<String, List<Employee>> map2 = emps.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.mapping(mapper, Collectors.toList())));
		
		map2.entrySet().forEach(System.out::println);
	}
}
