package com.javawiz.interview;

public class Sample {
	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2};
		System.out.println(getMEX(A));
	}
	
	public static int getMEX(int[] a) {
		  boolean found = false;
		  for (int i = 1;; i++) {
		    found = false;
		    for (int j = 0; j < a.length; j++) {
		      int x = a[j];
		      if (x == i) {
		        found = true;
		        break;
		      }
		    }
		    if (!found) {
		      return i;
		    }
		  }
		}
}
