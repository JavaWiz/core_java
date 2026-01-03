package com.javawiz.algorithm.search;

public class BS {
    public static int search(int[] array, int element){
        int start = 0, end = array.length -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(element == array[mid])
                return mid;
            else if(element> array[mid])
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }

    public static int bsRecursive(int[] array, int start, int end, int element){
        if(start<=end){
            int mid = start + (end - start)/2;
            if(array[mid] == element){
                return mid;
            } else if(array[mid] < element){
                return bsRecursive(array, mid + 1, end, element);
            } else {
                return bsRecursive(array, start, mid - 1, element);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 6, 7, 8};
        int index = bsRecursive(array, 0, array.length - 1, 5);
        System.out.println(index == -1 ? "Element not found." : "Element found at index => " + index);
    }
}
