package com.javawiz.defaultinterface;

public interface FourWheeler {
	default void print() {
		System.out.println("I am a four wheeler!");
	}
}