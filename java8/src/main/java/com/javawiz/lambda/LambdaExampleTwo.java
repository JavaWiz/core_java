package com.javawiz.lambda;

interface EvenOdd {
	boolean check(int a);
}

public class LambdaExampleTwo {
	public static void main(String[] args) {
		// Lambda Expression
		EvenOdd evenOdd = (int a) -> (a%2==0);
		System.out.println("Number is odd -> "+ !evenOdd.check(5));
		System.out.println("Number is even -> "+ evenOdd.check(7));


		EvenOdd isPrime =  x -> {

			return true;
		};
		
		//Check numbers
		evenOdd.check(5);
		evenOdd.check(8);
	}
}