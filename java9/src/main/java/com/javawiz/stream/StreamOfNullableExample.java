package com.javawiz.java9.stream;

import java.util.stream.Stream;
  
public class StreamOfNullableExample {  
    public static void main(String[] args) {  
        Stream<Integer> val   
        = Stream.ofNullable(null);     
    val.forEach(System.out::println);  
    }  
} 