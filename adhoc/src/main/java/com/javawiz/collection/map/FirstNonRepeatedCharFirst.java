package com.javawiz.collection.map;

public class FirstNonRepeatedCharFirst {
	public static void main(String args[]) {

		String inputStr = "aaaabbbcddee";
		
		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First non-repeating character is: " + i);
				break;
			}
		}
	}
}