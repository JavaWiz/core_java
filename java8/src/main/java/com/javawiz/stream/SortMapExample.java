package com.javawiz.stream;

import com.javawiz.model.Address;
import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Eight",8);
        map.put("One", 1);
        map.put("Five", 5);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Seven", 7);
        map.put("Two", 2);
        map.put("Six", 6);

        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Key     | Value   |%n");
        System.out.format("+-----------------+------+%n");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.format(leftAlignFormat, e.getKey(), e.getValue()));
        System.out.format("+-----------------+------+%n");
        System.out.println("==============================================================");
        System.out.format("+-----------------+------+%n");
        System.out.format("| Key     | Value   |%n");
        System.out.format("+-----------------+------+%n");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.format(leftAlignFormat, e.getKey(), e.getValue()));
        System.out.format("+-----------------+------+%n");
        System.out.println("==============================================================");
        CollectionDB.getEmployeeMap()
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getId)))
                .forEach(System.out::println);
        System.out.println("==============================================================");
        CollectionDB.getEmployeeMap()
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
                .forEach(System.out::println);
        System.out.println("==============================================================");
        CollectionDB.getEmployeeMap()
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Address::getAddressId)))
                .forEach(System.out::println);
    }
}
