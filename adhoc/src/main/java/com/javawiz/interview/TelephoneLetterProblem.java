package com.javawiz.interview;

import java.util.Scanner;

public class TelephoneLetterProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.length() > 7) {
			System.out.println("Invalid Phone number.");
			return;
		}

		String[] stArray = input.split("");
		String word = "";
		for (int i = 0; i < stArray.length; i++) {
			word = word + getLetters(stArray[i]);
		}

		System.out.println(word);
		sc.close();
	}

	private static String getLetters(String number) {
		String word = "";
		switch (number) {
		case "0":
			word = "0";
			break;
		case "1":
			word = "1";
			break;
		case "2":
			word = "abc";
			break;
		case "3":
			word = "def";
			break;
		case "4":
			word = "ghi";
			break;
		case "5":
			word = "jkl";
			break;
		case "6":
			word = "mno";
			break;
		case "7":
			word = "pqrs";
			break;
		case "8":
			word = "tuv";
			break;
		case "9":
			word = "wxyz";
			break;
		}
		return word;
	}
}
