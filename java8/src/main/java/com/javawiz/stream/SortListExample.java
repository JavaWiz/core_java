package com.javawiz.stream;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 9, 1, 8, 2, 4, 7);
        decendSort(list);
        
        List<Employee> employees = CollectionDB.getEmployees();
        System.out.println("---------- Sort In Ascending Order ----------");
        employees.stream().sorted().forEach(System.out::println);
        System.out.println("---------- Sort In Reverse Order -----------");
        employees.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("---------- Sort By Name Order---------------------");
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        System.out.println("---------- Sort By Name Reverse Order---------------------");
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
    }
    static
    private void ascendSort(List<Integer> list){
        list.stream().sorted().forEach(System.out::println);
    }

    private static void decendSort(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
