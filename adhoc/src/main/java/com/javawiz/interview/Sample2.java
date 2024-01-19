package com.javawiz.interview;

public class Sample2 {

	public static void main(String[] args) {
		int n = 4;
System.out.println(getRandomWord(4));
	}
	
	static String getRandomWord(int length) {
	    String r = "";
	    for(int i = 0; i < length; i++) {
	        r += (char)(Math.random() * 26 + 97);
	    }
	    return r;
	}

}
