package com.practice.Multithreading;

public class Q3bBlockSynchronized {

    private Integer integer = 10;
    private void increment() {
        this.integer++;
    }
    private void decrement() {
        this.integer--;
    }

    public static void main(String[] args) throws InterruptedException {
        Q3bBlockSynchronized blockSynchronized = new Q3bBlockSynchronized();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized(lock) {
                    blockSynchronized.increment();
                }
            }
        }, "IncrementThread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    blockSynchronized.decrement();
                }
            }
        }, "DecrementThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(6000);
        System.out.println(blockSynchronized.integer);
    }
}
