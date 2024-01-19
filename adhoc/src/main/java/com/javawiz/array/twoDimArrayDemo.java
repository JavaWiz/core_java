package com.javawiz.array;

public class twoDimArrayDemo {

	public static void main(String[] args) {

		int twoDim[][] = new int[2][3];
		twoDim[0][0] = 1;
		twoDim[0][1] = 2;
		twoDim[0][2] = 3;
		twoDim[1][0] = 4;
		twoDim[1][1] = 5;
		twoDim[1][2] = 6;

		System.out.println(twoDim[0][0] + " " + twoDim[0][1] + " " + twoDim[0][2]);
		System.out.println(twoDim[1][0] + " " + twoDim[1][1] + " " + twoDim[1][2]);
	}
}
