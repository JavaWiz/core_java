package com.javawiz.async;

import lombok.extern.slf4j.Slf4j;

public interface Calculator {
    static long factorial(long number) {
        return number == 0 ? 1 : number * factorial(number-1);
    }
}
