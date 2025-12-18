package com.javawiz;

import java.util.Deque;

public class BracketPatternMatchExample {

    public static void main(String[] args) {
        String input = "{[({})]}";
        System.out.println("Input: " + input + " is balanced: " + (isBalanced(input) ? "YES" : "NO"));
    }

    private static boolean isBalanced(String input){
        Deque<Character> deque = new java.util.ArrayDeque<>();
        for(char ch : input.toCharArray()){
            switch (ch) {
                case '{', '[', '(' -> deque.push(ch);
                case ')', '}', ']' -> {
                    if (deque.isEmpty() || !isMatched(deque.pop(), ch)) return false;
                }
            }
        }
        return deque.isEmpty();
    }

    private static boolean isMatched(Character open, char close) {
        return (open == '{' && close == '}') ||
               (open == '[' && close == ']') ||
               (open == '(' && close == ')');

    }
}
