package com.javawiz.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.spi.CurrencyNameProvider;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Calulate fibonacci of -> ");
		int n = sc.nextInt();
		System.out.println("");
		iterativeFirst(n);
		System.out.println("");
		iterativeSecond(n);
		System.out.println("");
		printRecursive(n);
		System.out.println(" -> Fibonacci("+n+") = "+recursive(n));
		System.out.println("");
		System.out.println("Fibonacci : "+fibWithCaching(n));
		System.out.println("");
		fibWithCHMCaching(n);
		sc.close();
	}
	
	public static void iterativeFirst(int n) {
		int n1 = 0, n2 = 1, n3;
		System.out.print("| "+ n1 + " | " + n2);// printing 0 and 1

		for (int i = 2; i <= n; i++){// loop starts from 2 because 0 and 1 are already printed
			n3 = n1 + n2;
			System.out.print(" | " + n3);
			n1 = n2;
			n2 = n3;
		}
		System.out.println(" |");
	}
	
	public static void iterativeSecond(int n) {
		int n1 = 0, n2 = 1, counter = 0;
		System.out.print("| ");
		while(counter++ <= n) {
			System.out.print(n1 +" | ");
			int n3  = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		System.out.println();
	}

	private static int recursive(int n) {
		return n<=1 ? n : recursive(n -1) + recursive(n -2);
	}

	private static void printRecursive(int n) {
		System.out.print("|");
		for (int i = 0; i <= n; i++) {
			System.out.print(" "+recursive(i)+" |");
		}
	}

	private static final Map<Integer, Integer> cache = new HashMap<>();

	public static int fibWithCaching(int n) {
		if (n <= 1)
			return n;

		Integer result = cache.get(n);

		if (result == null) {
			synchronized (cache) {
				result = cache.get(n);

				if (result == null) {
					System.out.println("calculating fib(" + n + ")");
					result = fibWithCaching(n - 1) + fibWithCaching(n - 2);
					cache.put(n, result);
				}
			}
		}
		return result;
	}

	private static final Map<Integer, Integer> HMP = new ConcurrentHashMap<>();
	public static int fibWithCHMCaching(int n){
		if (n <= 1)
			return n;

		return HMP.computeIfAbsent(n, k -> {
			System.out.println("calculating fib(" + k + ")");
			return fibWithCHMCaching(k - 1) + fibWithCHMCaching(k - 2);
		});
	}
}