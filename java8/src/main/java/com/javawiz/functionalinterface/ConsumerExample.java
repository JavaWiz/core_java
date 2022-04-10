package com.javawiz.functionalinterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {

	public static void main(String[] args) {
		
		Consumer<Integer> c = t -> System.out.println("Print : "+t);
		c.accept(10);
		
		Consumer<String> c1 = ConsumerExample::print;
		c1.accept("Hello");
		
		Stream.of(4, 5, 10, 2, 23, 12, 7, 25, 15).forEach(c);
	}

	public static void print(String t) {
		System.out.println("Print : "+ t);
	}
}
