package com.javawiz.interview.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 *
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Longest_Substring_Without_Repeating_Chars {
    public static void main(String[] args) {
        String str = /*"pwwkew"*/"abcabcbb";
        System.out.println("Longest substring without repeating characters (stream way): " + normalWay(str));
        System.out.println("Longest substring without repeating characters (sliding window way): " + slidingWindowWay(str));
        //System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(str));
    }

    private static String normalWay(String str){
        StringBuilder longestSubstring = new StringBuilder();
        StringBuilder currentSubstring = new StringBuilder();

        for (char c : str.toCharArray()) {
            // check if char exists in current substring,
            // if yes remove all chars before and including that char
            int index = currentSubstring.indexOf(String.valueOf(c));
            if (index != -1) {//
                currentSubstring.delete(0, index + 1);
            }
            // append current char to current substring
            currentSubstring.append(c);
            // update longest substring if current is longer
            if (currentSubstring.length() > longestSubstring.length()) {
                longestSubstring.setLength(0);
                longestSubstring.append(currentSubstring);
            }
        }
        return longestSubstring.toString();
    }

    //We can use a HashSet and two pointers (sliding window) for a shorter and efficient solution.
    // Here’s a concise version:
    private static String slidingWindowWay(String str) {
        int left = 0, right = 0, maxLength = 0, start = 0;
        Set<Character> set = new HashSet<>();

        while (right < str.length()) { // while right pointer is less than string length
            if (!set.contains(str.charAt(right))) { // if char at right pointer is not in set
                set.add(str.charAt(right)); // add char at right pointer to set
                int currentWindowLength = right - left + 1; // calculate current window length
                if (currentWindowLength > maxLength) {
                    maxLength = currentWindowLength;
                    start = left;
                }
                right++;
            } else {
                set.remove(str.charAt(left++));
            }
        }
        return str.substring(start, start + maxLength);
    }
}
