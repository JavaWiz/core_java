package com.javawiz.functionalinterface;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public interface Processor {
    String process(Callable<String> c) throws Exception;
    String process(Supplier<String> s);
    
    String processWithCallable(Callable<String> c) throws Exception;
    String processWithSupplier(Supplier<String> s);
}