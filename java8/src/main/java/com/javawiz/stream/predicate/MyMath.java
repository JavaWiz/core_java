package com.javawiz.stream.predicate;

public class MyMath {
	public boolean checker(PerformOperation op, int num) {
		return op.operation(num);
	}
	
	PerformOperation isOdd() {
		return x -> x%2 != 0;
	}

	public PerformOperation isPrime() {
		return x-> {
			if(x==2) return true;
			if(x%2==0) return false;
			for(int i=3;i*i<x;i+=2) {
				if(x%i == 0) return false;
			}
			return true;
		};
	}

	public PerformOperation isPalindrome() {
		return x-> {
			int palindrome = x;
			int reverse = 0;
			while(x!=0) {
				int r = x%10;
				reverse = reverse*10 + r;
				x = x/10;
			}
			return palindrome == reverse;
		};
	}
}
