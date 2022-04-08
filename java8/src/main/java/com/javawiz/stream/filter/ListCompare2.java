package com.javawiz.stream.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCompare2 {
	public static List < Employee > getEmployeeList() {
        List < Employee > employeeList = new ArrayList < > ();
        employeeList.add(new Employee(1, "Ninja Panda", 32, 200));
        employeeList.add(new Employee(2, "Maste Shifu", 36, 250));
        employeeList.add(new Employee(3, "Aidan Lloyd", 22, 300));
        employeeList.add(new Employee(4, "Aidan Lloyd", 34, 700));
        employeeList.add(new Employee(5, "PandaLuca Gallagher", 30, 1200));
        return employeeList;
    }
    public static void main(String[] args) {
        List < Integer > aList = Arrays.asList(new Integer[] {
            1,
            3,
            5,
            6,
            8});
        
        
        // If any number from List is present in List 2
        System.out.println(
            "If any number from aList is present in List 2 :" +
            aList.stream().anyMatch(num -> getEmployeeList().get(num).getId()== num));
    }
}