package com.javawiz.functionalinterface;

import java.util.function.Function;

public class Examples {
	public static void main(String[] args) {
		Function<Integer, Integer> add1 = x -> x + 1;
		Function<String, String> concat1 = x -> x + 1;
		
		Integer sum = add1.apply(1); //yields 2
		String answer1 = concat1.apply("0 + 1 = "); //yields "0 + 1 = 1"
		
		System.out.println(sum);
		System.out.println(answer1);
		
		Function<Integer,Integer> add2 = FunctionUtils::add;
		Function<String,String> answer2 = FunctionUtils::concat;
		
		System.out.println(add2.apply(2));
		System.out.println(answer2.apply("Hello"));
		
		Function<Integer, Function<Integer,Integer>> makeAdder = FunctionUtils::adder;
		Function<Integer,Integer> add = makeAdder.apply(1);
		System.out.println(add.apply(2));
		test(makeAdder);
	}
	
	public static void test(Function<Integer, Function<Integer,Integer>> makeAdder) {
		
		Function<Integer,Integer> add2 = makeAdder.apply(2);
		Function<Integer,Integer> add3 = makeAdder.apply(3).andThen(add2);
		
		System.out.println(makeAdder.apply(1).apply(2)+", "+add3.apply(4));
	}
}


