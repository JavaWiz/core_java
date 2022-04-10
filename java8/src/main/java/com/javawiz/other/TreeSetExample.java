package com.javawiz.other;

import java.util.TreeSet;

public class TreeSetExample {
    
    public static void main(String[] args) {
        TreeSet<String>  obj1= new TreeSet<String>();
        obj1.add("Alive");
        obj1.add("is");
        obj1.add("Awesome");
        obj1.add(null);
        System.out.println(obj1);
    }
}