package com.javawiz.interview.string;

public class StringImmutability {
    public static void main(String[] args) {
        String s = "hello";
        s.concat("world");
        System.out.println(s);
    }
}
