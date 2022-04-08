package com.javawiz.stream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultipleFilterExample {
    public static void main(String[] args) {
        List<Employee> employeeList = getEmployeesFromDataSource();

        //filter 1
        Predicate<Employee> isEmployeeActive = e -> e.getStatus() == EmployeeStatus.ACTIVE;

        //filter2
        Predicate<Employee> isAccountActive = e -> e.getAccount().getStatus() == AccountStatus.ACTIVE;

        //Active employees
        String result = employeeList.stream()
                .filter(isEmployeeActive)
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));

        System.out.println("Active employees = " + result);

        //Active employees with active accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.and(isAccountActive))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));

        System.out.println("Active employees with active accounts = " + result);

        //Active employees with inactive accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.and(isAccountActive.negate()))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));

        System.out.println("Active employees with inactive accounts = " + result);

        //Inactive employees with inactive accounts
        result = employeeList.stream()
                .filter(isEmployeeActive.negate().and(isAccountActive.negate()))
                .map(e -> String.valueOf(e.getId()))
                .collect(Collectors.joining(",", "[", "]"));

        System.out.println("Inactive employees with inactive accounts = " + result);
    }

    private static List<Employee> getEmployeesFromDataSource() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "A", EmployeeStatus.ACTIVE,
                new Account(1001L, "Saving - 1001", "Saving", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(2, "B", EmployeeStatus.ACTIVE,
                new Account(1002L, "Checking - 1002", "Checking", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(3, "C", EmployeeStatus.ACTIVE,
                new Account(1003L, "Deposit - 1003", "Deposit", AccountStatus.ACTIVE)));
        employeeList.add(new Employee(4, "D", EmployeeStatus.ACTIVE,
                new Account(1004L, "Saving - 1004", "Saving", AccountStatus.INACTIVE)));
        employeeList.add(new Employee(5, "E", EmployeeStatus.ACTIVE,
                new Account(1005L, "Checking - 1005", "Checking", AccountStatus.INACTIVE)));
        employeeList.add(new Employee(6, "F", EmployeeStatus.ACTIVE,
                new Account(1006L, "Deposit - 1006", "Deposit", AccountStatus.BLOCKED)));

        return employeeList;
    }
}


