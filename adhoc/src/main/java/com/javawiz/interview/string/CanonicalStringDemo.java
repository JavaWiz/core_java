package com.javawiz.interview.string;

public class CanonicalStringDemo {
    public static void main(String[] args) {
        // String literal - automatically interned and placed in the pool
        String str1 = "Java Exercises"; 

        // String object created using new, not automatically interned
        String str2 = new StringBuilder("Java").append(" Exercises").toString();
        
        // Get the canonical representation of str2
        String str3 = str2.intern(); 

        // Comparison:
        // str1 and str2 are in different memory locations (Heap vs String Pool)
        System.out.println("str1 == str2? " + (str1 == str2)); // Output: false

        // str1 and str3 both refer to the same canonical instance in the String Pool
        System.out.println("str1 == str3? " + (str1 == str3)); // Output: true
    }
}
