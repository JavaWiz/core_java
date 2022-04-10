package com.javawiz.functionalinterface;

import java.util.function.Function;

public class FunctionExample {

	// find even, odd, avg, prime
	public static void main(String[] args) {
		Function<Integer, Boolean> fn1 = FunctionExample::isOdd;
		System.out.println(fn1.apply(23) ? "An odd number." : "An even number.");

		Function<Integer, Boolean> fn2 = FunctionExample::isPrime;
		System.out.println(fn2.apply(1) ? "A prime number." : "Not a prime number.");
			
		// Function which takes in a number and
        // returns half of it
        Function<Integer, Double> half = a -> a / 2.0;
  
        // Now triple the output of half function
        half = half.andThen(a -> 3 * a);
  
        // apply the function to get the result
        System.out.println(half.apply(10));
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n > 2 && n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static boolean isOdd(int n) {
		return !(n % 2 == 0);
	}
}
