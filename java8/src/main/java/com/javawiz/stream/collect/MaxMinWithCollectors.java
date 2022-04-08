package com.javawiz.stream.collect;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class MaxMinWithCollectors {
    private static final List<Employee> employeeList = CollectionDB.getEmployees();

    public static void main(String[] args) {
        Optional<Employee> maxSalaryEmp =
                employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("Employee with max salary:"
                + (maxSalaryEmp.isPresent() ? maxSalaryEmp.get() : "Not Applicable"));
        Optional<Employee> minAgeEmp =
                employeeList.stream().min(Comparator.comparing(Employee::getAge));
        System.out.println("Employee with min age:"
                + (minAgeEmp.isPresent() ? minAgeEmp.get() : "Not Applicable"));
    }
}