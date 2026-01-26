package com.javawiz.practice;

public class Sample {
    public static void main(String[] args) {
        String s = "abcabcbb";
        StringBuilder ls = new StringBuilder();
        StringBuilder cs = new StringBuilder();
        for(char c : s.toCharArray()){
            int index = cs.indexOf(String.valueOf(c)); // check if char exists in current substring
            if(index != -1){ // char exists in current substring
                System.out.println("Found repeating char: " + c);
                cs.delete(0, index + 1);
                System.out.println("Current substring after removing repeating char: " + cs.toString());
            }
            cs.append(c);
            if(cs.length() > ls.length()){
                ls.setLength(0);
                ls.append(cs);
            }
        }
        System.out.println("Longest substring without repeating characters: " + ls.toString());
    }
}
