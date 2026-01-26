package com.javawiz.interview.string;

import java.util.HashSet;
import java.util.Set;
/**
 * Pangram Checker
 * A pangram is a sentence that contains every letter of the alphabet at least once.
 * This program checks if a given string is a pangram.
 *
 * Example 1:
 * Input: "We promptly judged antique ivory buckles for the next prize"
 * Output: "pangram"
 *
 * Example 2:
 * Input: "We promptly judged antique ivory buckles for the prize"
 * Output: "not pangram"
 */
public class Pangram {
    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
    }

    public static String pangrams(String s) {
        Set<Character> set = new HashSet<>();

        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }

}
