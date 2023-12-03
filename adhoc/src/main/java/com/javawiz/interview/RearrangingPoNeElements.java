package com.javawiz.interview;

import java.util.Arrays;

//Rearranging positive and negative values in an array
public class RearrangingPoNeElements {
	
	public static void main(String[] args) {
		int n = 9;
		int arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
		rearrange(arr, n);
		
	}
	
	static void rearrange(int arr[], int n) {
		int[] po = new int[arr.length];
		int[] ne = new int[arr.length];
		int j = 0, k = 0;
		for (int i = 0; i < ne.length; i++) {
			if(arr[i]>0)
				po[j++]=arr[i];
			else
				ne[k++] = arr[i];
		}
		System.out.println(Arrays.toString(po));
		System.out.println(Arrays.toString(ne));
		
		for (int i = 0; i < ne.length; i++) {
			if(po[i]!=0)
				System.out.print(po[i]+ " ");
			if(ne[i]!=0)
				System.out.print(ne[i]+" ");
		}
        
    }
}
