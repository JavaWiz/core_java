package com.javawiz.interview;

public class Sample3 {

	public static void main(String[] args) {
		//int N = 15958;
		//int N = -5859;
		int N = -50050;
		System.out.println(test2(N));
	}

	static int test(int N) {
		int digit;
		int number = Math. abs(N);
		String st = "";
		while (number > 0) {
			digit = number % 10;
			st = digit + st;
			number = number / 10;
		}
		System.out.println(st);
		StringBuilder sb = new StringBuilder(st);
		if (N > 0) {
			sb.deleteCharAt(st.indexOf("5"));
			return Integer.parseInt(sb.toString());
		} else if (N < 0) {
			sb.deleteCharAt(st.lastIndexOf("5"));
			return Integer.parseInt("-"+sb.toString());
		}
		return 0;
	}
	
	static int test2(int N) {
		String st = ""+N;
		System.out.println(st);
		StringBuilder sb = new StringBuilder(st);
		if (N > 0) {
			sb.deleteCharAt(st.indexOf("5"));
			return Integer.parseInt(sb.toString());
		} else if (N < 0) {
			sb.deleteCharAt(st.lastIndexOf("5"));
			return Integer.parseInt(sb.toString());
		}
		return 0;
	}
}
