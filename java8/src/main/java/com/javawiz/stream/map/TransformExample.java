package com.javawiz.stream.map;

import com.javawiz.data.CollectionDB;

import java.util.List;
import java.util.stream.Collectors;

public class TransformExample {
    public static void main(String[] args) {
        List<String> names = CollectionDB.getEmployees().stream().map(e -> e.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(names);
    }
}
