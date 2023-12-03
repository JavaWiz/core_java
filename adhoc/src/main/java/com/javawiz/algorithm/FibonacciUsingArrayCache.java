package com.javawiz.algorithm;

import java.util.Scanner;

public class FibonacciUsingArrayCache {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Calulate fibonacci n -> ");
		int n = sc.nextInt();
		System.out.println("");
		
		long startTime = System.nanoTime();
		printRecursive(n);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
		System.out.println("\nFibonacci("+n+") tooks "+ duration + " milliseconds");
		
		sc.close();
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
}