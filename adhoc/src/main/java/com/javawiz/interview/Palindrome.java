package com.javawiz.interview;

public class Palindrome {

    public static void main(String[] args) {
        int number = 123321;
        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int original = x;
        int reverse = 0;
        while(x>0){
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x/10;
        }
        return reverse == original;
    }

    public boolean isPalindromeReverseHalf(int x) {
        // Negative numbers or numbers ending with 0 (but not 0 itself) cannot be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }

        // For even digits: x == reversedHalf
        // For odd digits:  x == reversedHalf / 10 (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }


}
