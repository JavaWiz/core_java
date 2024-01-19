package com.javawiz.interview;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		//3, 1, 5, 7, 6, 9
		s.push(3);
		s.push(1);
		s.push(5);
		s.push(7);
		s.push(6);
		s.push(9);
		
		print(s);
	}

	private static void print(Stack<Integer> s) {
		if(s.isEmpty())
			return;
		else {
			int temp = s.pop();
			print(s);
			System.out.print(temp+" ");
		}
	}
}
