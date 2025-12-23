package com.javawiz.stream;

import com.javawiz.model.Employee;
import java.util.Map;
import java.util.stream.Collectors;

public class FindHighestAvgSalaryOfEmp {

    public static void main(String[] args) {
        Employee.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::department,
                                               Collectors.averagingDouble(Employee::salary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Department with highest average salary: " +
                        entry.getKey() + " with average salary: " + entry.getValue()));
    }

    public void usingSummaryStatistics() {
        var stats = Employee.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.summarizingDouble(Employee::salary)));

        stats.entrySet().stream()
                .max(Map.Entry.comparingByValue((s1, s2) -> Double.compare(s1.getAverage(), s2.getAverage())))
                .ifPresent(entry -> System.out.println("Department with highest average salary: " +
                        entry.getKey() + " with average salary: " + entry.getValue().getAverage()));
    }
}
