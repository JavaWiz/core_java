package com.javawiz.interview.string;

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
        String str = "pwwkew";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(str));
    }

    private static String lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        String longestSubstring = "";

        for (int end = 0; end < n; end++) {
            for (int i = start; i < end; i++) {
                if (str.charAt(end) == str.charAt(i)) {
                    start = i + 1;
                    break;
                }
            }
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestSubstring = str.substring(start, end + 1);
            }
        }
        return longestSubstring;
    }
}
