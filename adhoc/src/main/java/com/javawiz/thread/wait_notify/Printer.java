package com.javawiz.thread.wait_notify;

public class Printer {
    private int number = 1;
    private final int maxCount = 10;
    private boolean isOddTurn = true;

    public void printOdd() {
        synchronized (this) {
            while (number<= maxCount) {
                while (!isOddTurn) {
                    try {
                        wait(); // 👈 wait for even thread to signal
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Odd: " + number);
                number++;
                isOddTurn = false;
                notify(); // 👈 signal even thread
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (number <= maxCount) {
                while (isOddTurn) {
                    try {
                        wait(); // 👈 wait for odd thread to signal
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even: " + number);
                number++;
                isOddTurn = true;
                notify(); // 👈 signal odd thread
            }
        }
    }

    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
