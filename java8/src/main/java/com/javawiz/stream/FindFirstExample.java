package com.javawiz.stream;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstExample {
    public static void main(String[] args) {
        List<Employee> employeeList = CollectionDB.getEmployees();
        List<Employee> emptylist = new ArrayList<>();

        System.out.println(employeeList.stream().findFirst().get().getName());

        System.out.println(employeeList.stream().findAny().get().getName());

        System.out.println(emptylist.stream().findFirst().map(Employee::getName).orElse(""));

        // Creating a List of Integers
        List<Integer> list = Arrays.asList(3, 5, 7, 9, 11);

        // Using Stream findFirst()
        Optional<Integer> answer = list.stream().findFirst();
        // if the stream is empty, an empty
        // Optional is returned.
        if (answer.isPresent()) {
            System.out.println(answer.get());
        }
        else {
            System.out.println("no value");
        }
    }
}
