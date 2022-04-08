package com.javawiz.stream.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListCompare {
    public static void main(String[] args) {
        List < Integer > aList = Arrays.asList(new Integer[] {
            1,
            3,
            5,
            6,
            8});
        
        List < Integer > bList = Arrays.asList(new Integer[] {
            10,
            89,
            8,
            6
        });
        // If any number from List is present in List 2
        System.out.println(
            "If any number from aList is present in List 2 :" +
            aList.stream().anyMatch(num -> bList.contains(num)));
        // If any number from List is present in List 2
        System.out.println(
            "If any number from aList is not present in List 2 :" +
            aList.stream().noneMatch(num -> bList.contains(num)));
        // If any number from List is present in List 2
        System.out.println(
            "If all numbers from aList are present in List 2 :" +
            aList.stream().allMatch(num -> bList.contains(num)));
        
        List<Integer> list = aList.stream().filter(num -> bList.contains(num)).collect(Collectors.toList());
        
        list.forEach(System.out::println);
        
        Integer[] array = new Integer[] {
                1,
                3,
                5,
                6,
                8};
        
        Arrays.asList(array).stream().filter(num -> bList.contains(num)).collect(Collectors.toList()).forEach(System.out::println);
        
    }
}