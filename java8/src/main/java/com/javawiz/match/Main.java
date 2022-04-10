package com.javawiz.match;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javawiz.model.Employee;

public class Main {
    //MatchingWithStreams.java
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45),
                new Employee("Harry Major", 25),
                new Employee("Ethan Hardy", 65),
                new Employee("Nancy Smith", 22),
                new Employee("Deborah Sprightly", 29));

        Predicate<Employee> predicate = emp -> emp.getAge() > 21;
        System.out.println("All employees are above 21:" + employeeList.stream().allMatch(predicate));
        System.out.println("Any employees are above 21:" + employeeList.stream().anyMatch(predicate));
        System.out.println("None employees are less than 21:" + employeeList.stream().noneMatch(predicate));
        
        List<String> list = Arrays.asList("Hercules", "Heros", "Thor", "Black Widow");
        
        boolean isAnyMatch = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isAllMatch = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isNoneMatch= list.stream().noneMatch(element -> element.contains("h")); // false
        
        System.out.println("Any name contains h : "+ isAnyMatch);
        System.out.println("All names contains h : "+ isAllMatch);
        System.out.println("None names contains h : "+ isNoneMatch);
        
        List<String> resultList = Stream.of("Hercules", "Thor", "Black Widow")
        .map(String::toUpperCase).collect(Collectors.toList());
        
        System.out.println(resultList);
        
        list.parallelStream().forEach(Main::doWork);

    }

	private static void doWork(String element) {
		System.out.println(element);
	}
}
