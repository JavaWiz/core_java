package com.javawiz.interview.string;

public class StringRegexExample {
    public static void main(String[] args) {
        String s = "   He is a     very very _good! boy, isn't he?";
        //String s="";
        String delimiters = "[, ?._'!@]+";


        if(s.length()>0){
            // analyzing the string
            String[] tokens = s.trim().split(delimiters);

            // prints the number of tokens
            System.out.println(tokens.length);
            for(String token : tokens) {
                System.out.println(token);
            }
        } else{
            System.out.println(s.length());
        }
    }
}
