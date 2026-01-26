package com.javawiz.interview.string;

import java.util.Arrays;

public class AnagramChecker {

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (isAnagram(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

    /**
     * Checks if two strings are anagrams of each other.
     * @param s1 The first string.
     * @param s2 The second string.
     * @return true if the strings are anagrams, false otherwise.
     */
    public static boolean isAnagram(String s1, String s2) {
        // Remove spaces and convert to lowercase for a case-insensitive comparison.
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are equal. If not, they cannot be anagrams.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare the sorted arrays
        return Arrays.equals(arr1, arr2);
    }
}
