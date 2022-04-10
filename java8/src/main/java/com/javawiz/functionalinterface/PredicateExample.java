package com.javawiz.functionalinterface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> p = t -> t%2==0;
		
		System.out.println("Is it an even? "+p.test(12));
		
		Stream.of(4, 5, 10, 2, 23, 12, 7, 25, 15).filter(p).forEach(System.out::println);
	}
}
