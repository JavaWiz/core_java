package com.javawiz.interview.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BracketPatternMatchExample {

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Input: " + input + " is balanced: " + isBalanced(input));
        System.out.println("Input: " + input + " is balanced (Deque): " + isBalancedDeque(input));
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty() || !isMatchingBracket(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    /**
     * Deque is generally preferred over Stack in modern Java for several reasons:
     * <ul>
     *   <li><b>Stack is legacy:</b> Stack is a very old class (from Java 1.0) and is considered legacy. It extends Vector, which means it inherits unnecessary methods and overhead.</li>
     *   <li><b>Deque is part of Java Collections Framework:</b> Deque (like ArrayDeque or LinkedList) is part of the Java Collections Framework and is designed specifically for stack and queue operations.</li>
     *   <li><b>Performance:</b> ArrayDeque is usually faster than Stack because it does not have the synchronization overhead that Stack (which is synchronized) has.</li>
     *   <li><b>Cleaner API:</b> Deque provides clear methods for stack operations:
     *     <ul>
     *       <li>push() (addFirst)</li>
     *       <li>pop() (removeFirst)</li>
     *       <li>peek() (peekFirst)</li>
     *     </ul>
     *     This makes the code more readable and intention-revealing.</li>
     *   <li><b>Flexibility:</b> Deque can be used as both a stack and a queue, making it more versatile.</li>
     * </ul>
     * <p><b>Summary:</b> Use Deque (usually ArrayDeque) for stack operations in modern Java code. Stack is only kept for backward compatibility and should be avoided in new code.</p>
     */

    private static boolean isBalancedDeque(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for(Character c : input.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                deque.push(c);
            } else if(c == '}' || c == ']' || c == ')'){
                if(deque.isEmpty() || !isMatchingBracket(deque.pop(), c)) return false;
            }
        }
        return deque.isEmpty();
    }

    private static boolean isMatchingBracket(char open, char close){
        // Returns true if 'open' and 'close' form a valid bracket pair
        return (open == '{' && close == '}') ||
               (open == '[' && close == ']') ||
               (open == '(' && close == ')');
    }
}
