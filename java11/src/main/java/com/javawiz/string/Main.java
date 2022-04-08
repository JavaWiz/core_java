package com.javawiz.java11.string;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        
        System.out.println(" ".isBlank()); //true
        //isBlank() – This instance method returns a boolean value. Empty Strings and Strings with only white spaces are treated as blank.
        String s = "Ranjan";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true

        //lines() - This method returns a stream of strings, which is a collection of all substrings split by lines.
        String str = "JD\nJD\nJD";
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
    }
}