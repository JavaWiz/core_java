package com.javawiz.stream.filter;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private int salary;

    private EmployeeStatus status;
    private Account account;

    public Employee(int id, String name, int age, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id, String name, EmployeeStatus status, Account account){
        this.id = id;
        this.name = name;
        this.status = status;
        this.account = account;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}