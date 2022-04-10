package com.javawiz.lambda;

interface Circle {
	double area(double r);
}

public class LambdaExampleThree {
	public static void main(String[] args) {
		// Lambda Expression
		Circle circle=(double r)-> (Math.PI*r*r);
		
		//Print area of circle
		System.out.println("Area of Circle = "+circle.area(5));
	}
}