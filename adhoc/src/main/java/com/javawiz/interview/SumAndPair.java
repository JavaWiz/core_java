package com.javawiz.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAndPair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] stArray = input.split(";");
		
		String[] numStr = stArray[0].split(",");
		Integer[] array = new Integer[numStr.length];
		for (int i = 0; i < numStr.length; i++) {
			array[i] = Integer.parseInt(String.valueOf(numStr[i]).trim());
		}
		
		int sum = Integer.parseInt(String.valueOf(stArray[1]).trim());
		printPairs(array, sum);
		
		sc.close();
	}

	public static void printPairs(Integer[] array, int sum) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(i<=j && (array[i]+array[j]) == sum) {
					Pair pair = new Pair(array[i], array[j]);
					pairs.add(pair);
				}
			}
		}
		
		if(pairs!=null)
			System.out.println(pairs);
		else
			System.out.println("NULL");
	}
}

class Pair {
	private int i;
	private int j;
	
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "(" + i + ", " + j + ")";
	}
}
