package com.javawiz.interview.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BracketMatchExample {

    public static void main(String[] args) {
        String str = "{[[()]]}";
        System.out.println("Bracket match result: " + areBracketsMatched(str));
    }

    private static boolean areBracketsMatched(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean areBracketsMatchedWithSwitch(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        return deque.isEmpty();
    }

    private static boolean isMatch(char open, char close) {
        return (open == '{' && close == '}') ||
            (open == '[' && close == ']') ||
            (open == '(' && close == ')');
    }
}
