package com.javawiz.stream;
import java.util.stream.Stream;

public class IterateMethodExample {
    public static void main(String[] args) {
        Stream.iterate(0, i -> i + 1)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .limit(5)
              .forEach(i -> {});
  
        System.out.println();
  
        Stream.iterate(0, i -> i + 1)
              .limit(5)
              .map(i -> i + 1)
              .peek(i -> System.out.println("Map: " + i))
              .forEach(i -> {});
    }
}