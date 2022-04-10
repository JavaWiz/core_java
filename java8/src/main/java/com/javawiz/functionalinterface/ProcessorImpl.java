package com.javawiz.functionalinterface;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ProcessorImpl implements Processor {
	
    @Override
    public String process(Callable<String> c) throws Exception {
		return c.call();
    }

    @Override
    public String process(Supplier<String> s) {
		return s.get();
    }

	@Override
	public String processWithCallable(Callable<String> c) throws Exception {
		return c.call();
	}

	@Override
	public String processWithSupplier(Supplier<String> s) {
		return s.get();
	}
}