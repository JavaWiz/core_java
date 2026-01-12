package com.javawiz.interview.array;

public class ArrayElementCount {

    public static void main(String[] args) {
        //array [1,0,1,1,1,0,1,0]
        int[] array = {1,0,1,1,1,0,1,0};
        normalWay(array);
        bitwiseWay(array);
    }

    private static void bitwiseWay(int[] array) {
        int count = 0;
        for (int i : array) {
            count += i & 1;
        }
        System.out.println(count);
    }

    private static void normalWay(int[] array) {
        int count = 0;
        for(int num: array){
            count += num;
        }
        System.out.println(count);
    }
}
