package com.javawiz.algorithm.search;

import java.util.Scanner;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 6, 7 , 8};
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter element to search : ");
            int element = sc.nextInt();
            int index = BinarySearch.search(element, array);
            System.out.println(index != -1 ? "Element at index : " + index : "Element not found.");
            System.out.print("Still want to continue (y/n) : ");
        } while (sc.next().equalsIgnoreCase("y"));
        sc.close();
    }
}
