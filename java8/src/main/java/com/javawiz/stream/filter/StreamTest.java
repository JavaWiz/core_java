package com.javawiz.stream.filter;
import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static int ADULT = 18;
    public static List < Employee > getEmployeeList() {
        List < Employee > employeeList = new ArrayList < > ();
        employeeList.add(new Employee(1, "Ninja Panda", 32, 200));
        employeeList.add(new Employee(2, "Maste Shifu", 36, 250));
        employeeList.add(new Employee(3, "Aidan Lloyd", 22, 300));
        employeeList.add(new Employee(4, "Aidan Lloyd", 34, 700));
        employeeList.add(new Employee(5, "PandaLuca Gallagher", 30, 1200));
        return employeeList;
    }
    public static void main(String[] args) {
        List < Employee > employeeList = getEmployeeList();
        // is all employees are Adult.
        System.out.println("Are all employees are adult: " +
            employeeList.stream().allMatch(EmployeePredicates.isAdult()));
        // is there is an employee whose salary is more than 1000
        System.out.println("Has employee with more than 1000 salary: " +
            employeeList.stream()
            .anyMatch(EmployeePredicates.isSalaryMoreThan(1000)));
        // is there is an employee whose salary is more than 1000
        System.out.println("Has employee with more than 1500 salary: " +
            employeeList.stream()
            .anyMatch(EmployeePredicates.isSalaryMoreThan(1500)));
        // do we have an employee named Andy
        System.out.println("We do not have an employee named Andy: " +
            employeeList.stream()
            .noneMatch(e -> e.getName().contains("Andy")));
    }
}