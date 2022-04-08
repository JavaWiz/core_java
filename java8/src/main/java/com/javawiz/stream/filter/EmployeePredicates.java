package com.javawiz.stream.filter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {
    public static Predicate < Employee > isAdult() {
        return p -> p.getAge() > StreamTest.ADULT;
    }
    public static Predicate < Employee > isSalaryMoreThan(Integer salary) {
        return p -> p.getSalary() > salary;
    }
    public static List < Employee > filterAndGetEmployees(List < Employee > employees, Predicate < Employee > predicate) {
        return employees.stream().filter(predicate)
            .collect(Collectors. < Employee > toList());
    }
}