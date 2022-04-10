package com.javawiz.lambda;

public interface Condition {
	boolean test(Person p);

	default boolean test1(Person p) {
		return false;
	}

	default boolean test2(Person p) {
		return false;
	}

	default boolean test3(Person p) {
		return false;
	}
}