package com.practice.Multithreading;

class Threadclass extends Thread{

    @Override
    public void run() {
        for(int i=1;i<5;i++)
            System.out.println("Thread class " + Thread.currentThread().getName() + " is running.");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Threadclass2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable thread " + Thread.currentThread().getName() + " is running.");
    }
}

public class Q1RunnableThread {
    public static void main(String[] args) throws InterruptedException {

        Threadclass ob = new Threadclass();
        ob.start();

        ob.join();

        Thread obj = new Thread(new Threadclass2());
        obj.start();

    }
}
