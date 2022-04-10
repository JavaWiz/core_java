package com.javawiz.functionalinterface;

import java.util.function.Supplier;

public class ProcessorMain {
	public static void main(String[] args) throws Exception {
		Processor processor = new ProcessorImpl();
		String result1 = processor.processWithCallable(() -> "abc");
		System.out.println(result1);
		String result2 = processor.process((Supplier<String>) () -> "abc");
		System.out.println(result2);
	}
}
