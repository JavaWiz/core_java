package com.javawiz.stream.collect;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningWithCollectors {
    private static final List<Employee> employeeList = CollectionDB.getEmployees();

    public static void main(String... args) {
        Map<Boolean, List<Employee>> employeeMap
                = employeeList
                .stream()
                .collect(Collectors.partitioningBy((Employee emp) -> emp.getAge() > 35));
        System.out.println("Employees partitioned based on Predicate - 'age > 35'");
        employeeMap.forEach((Boolean key, List<Employee> empList) -> System.out.println(key + "->" + empList));
    }
}