package com.practice.Multithreading;

public class Q3aMethodSynchronized
{
    private Integer integer = 10;
    private synchronized void increment() {
        this.integer++;
    }
    private synchronized void decrement() {
        this.integer--;
    }

    public static void main(String[] args) throws InterruptedException {
        Q3aMethodSynchronized methodSynchronized = new Q3aMethodSynchronized();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                methodSynchronized.increment();
            }
        }, "IncrementThread");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                methodSynchronized.decrement();
            }
        }, "DecrementThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Thread.sleep(5000);
        System.out.println(methodSynchronized.integer);
    }
}