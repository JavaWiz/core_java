package com.javawiz.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveArrayToStream {

	public static void main(String[] args) {
		int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream 
        Arrays.stream(intArray)
        .forEach(System.out::println);
        
        System.out.println("---");
        Stream.of(intArray) //Stream.of -> Stream<int[]>
                .flatMapToInt(Arrays::stream)// Cant print Stream<int[]> directly, convert / flat it to IntStream
        .forEach(System.out::println);
	}
}
