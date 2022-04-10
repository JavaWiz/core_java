package com.javawiz.functionalinterface;

import java.util.function.Function;

public class FunctionUtils {
	public static Integer add(Integer x) {
		return x + 1;
	}

	public static String concat(String x) {
		return x + 1;
	}
	
	public static Function<Integer, Integer> adder(Integer x) {
       return y -> x + y;
    }
}

