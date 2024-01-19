package com.javawiz.interview;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
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

	private List<String> list = new ArrayList<>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		List<String> copy = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(i + "/" + list.size() + " " + list.get(i));
		}
		this.list = copy;
	}
}
