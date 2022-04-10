package com.javawiz.other;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Examples {
	public static void main(String[] args) {
		
		// Generate 10 random numbers between 10 to 20
		new Random().ints(10, 20).limit(10).sorted()
		.forEach(System.out::println);
		System.out.println();
		
		List<String> list = Arrays.asList("abc","", "bcd", "cde","def","efg");
		Predicate<String> test = s -> !s.isEmpty();
		list.stream().filter(test).collect(Collectors.toList())
		.forEach(System.out::println);
		System.out.println();
		
		List<Integer> numbers = Arrays.asList(4,2,3,2,4,5,3,6,7);
		List<Integer> squareList = numbers.stream()
		//Returns a stream consisting of the results 
		//of applying the given function to the elements of this stream.
		.map(i -> i*i)
		.distinct()
		.collect(Collectors.toList());
		squareList.forEach(System.out::println);
	}
}
