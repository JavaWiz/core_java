package com.javawiz.stream.flatmap;

import com.javawiz.data.CollectionDB;

import java.util.List;
import java.util.stream.Collectors;

public class FlatmapExample {
    public static void main(String[] args) {
    	
        List<String> phoneNumbers = CollectionDB.getEmployees().stream()
        		.flatMap(employee -> employee.getPhoneNumbers().stream()).collect(Collectors.toList());
        
        System.out.println(phoneNumbers);
    }
}