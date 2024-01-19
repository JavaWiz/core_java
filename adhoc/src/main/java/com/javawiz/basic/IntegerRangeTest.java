package com.javawiz.basic;

/*
* When we compile a number literal in Java and assign it to a Integer (capital I) the compiler emits:
* Integer b2 =Integer.valueOf(127)
* This line of code is also generated when you use autoboxing.
* valueOf is implemented such that certain numbers are "pooled", and it returns the same instance for values smaller than 128.
* From the java 1.6 source code, line 621:
    public static Integer valueOf(int i) {
        if(i >= -128 && i <= IntegerCache.high)
            return IntegerCache.cache[i + 128];
        else
            return new Integer(i);
    }
* The value of high can be configured to another value, with the system property.
*
*/

public class IntegerRangeTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        int k = 128;
        int l = 128;

        if(i==j) System.out.println("equal");
        if(k==l) System.out.println("not equal");

        IntegerRangeTest ipt = new IntegerRangeTest();
        ipt.print(1, 2);
        ipt.print(Integer.valueOf(1), Integer.valueOf(2));
    }

    public void print(int i, int j){
        System.out.println("int");
    }

    public void print(Integer i, Integer j){
        System.out.println("integer wrapper");
    }

    public void print(Integer... k){
        System.out.println("integer var arg");
    }
}
