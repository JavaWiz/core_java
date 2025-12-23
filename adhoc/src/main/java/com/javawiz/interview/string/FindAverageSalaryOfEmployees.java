package com.javawiz.interview.string;

public class FindAverageSalaryOfEmployees {

    public static void main(String[] args) {
        String[] employees = {
            "John,50000",
            "Jane,60000",
            "Doe,55000",
            "Alice,70000"
        };

        double averageSalary = findAverageSalary(employees);
        System.out.println("Average Salary: " + averageSalary);
    }

    private static double findAverageSalary(String[] employees) {
        double totalSalary = 0;
        for (String employee : employees) {
            String[] parts = employee.split(",");
            totalSalary += Double.parseDouble(parts[1]);
        }
        return totalSalary / employees.length;
    }
}
