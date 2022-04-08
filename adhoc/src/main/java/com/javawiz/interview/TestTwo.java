package com.javawiz.interview;

public class TestTwo {
    public static void main(String[] args) {
        int i = 2;
        final long j = 2;

        switch (i){
            case 1:
                System.out.println(1);
                break;
            /*case j://Compile issue - possible lossy conversion from long to int
                System.out.println(j);
                break;
                */
            case 10:
                System.out.println(10);
                break;
        }
    }
}
