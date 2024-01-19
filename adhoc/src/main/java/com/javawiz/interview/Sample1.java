package com.javawiz.interview;

public class Sample1 {

	public static void main(String[] args) {
		int n = 99;
		System.out.println(solution(n));
	}

	public static int solution(int N) {
		int sum = getSum(N);
		int number = sum * 2;
		while(N++>0) {
			if (number == getSum(N)) {
				break;
			}
		}
		return N;
	}
	
	private static int getSum(int N) {
		int digit, sum = 0;
		while (N > 0) {
			digit = N % 10;
			sum = sum + digit;
			N = N / 10;
		}
		return sum;
	}

}
