package com.javawiz.record_pattern;

public class RecordPatternExample {

    public static void main(String[] args) {
        Object obj = new Order(101, 2500.75);
        if (obj instanceof Order(int id, double amt)) { // Record Pattern Matching
            System.out.println(id + " " + amt);
        }
    }
}
