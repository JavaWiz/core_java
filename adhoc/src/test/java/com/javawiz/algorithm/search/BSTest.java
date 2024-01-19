package com.javawiz.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BSTest {
	
	@Test
	public void test_recursive_BS() {
		int[] array = new int[]{2, 4, 5, 6, 7, 8};
		for (int i = 0; i < array.length; i++) {
			assertEquals(BS.bsRecursive(array, 0, array.length - 1, array[i]), i);
		}
	}
}
