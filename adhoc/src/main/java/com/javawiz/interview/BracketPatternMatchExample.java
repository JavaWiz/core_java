package com.javawiz.interview;

import java.util.Deque;
import java.util.Stack;

public class BracketPatternMatchExample {

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Input: " + input + " is balanced: " + isBalanced(input));
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty() || !isMatched(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatched(char open, char close){
        return (open == '{' && close == '}') ||
               (open == '[' && close == ']') ||
               (open == '(' && close == ')');
    }
}
