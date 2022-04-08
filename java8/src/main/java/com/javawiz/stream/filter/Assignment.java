package com.javawiz.stream.filter;

import java.util.Arrays;
import java.util.List;

public class Assignment {

	public static void main(String[] args) {
		boolean flag = exist( Arrays.asList(4,1,3,7,8), 7);
		System.out.println(flag ? "YES" : "NO");
	}
	
	static boolean exist(List<Integer> list, int k) {
		return list.stream().filter(l -> l==k).count() > 0 ? true : false;
	}

}
