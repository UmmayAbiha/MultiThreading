package com.practice.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// Q2 Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.

public class Q2Tasks {
    public static void main(String args[])
    {
        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        try {
            singleThreadExecutor.submit(new UsableThread());

            cachedThreadPool.submit(new UsableThread());
            cachedThreadPool.submit(new UsableThread());
            cachedThreadPool.submit(new UsableThread());

            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());
            fixedThreadPool.submit(new UsableThread());



            singleThreadExecutor.shutdown();
            singleThreadExecutor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown singleThreadExecutor");


            cachedThreadPool.shutdown();
            cachedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown cachedThreadPool");


            fixedThreadPool.shutdown();
            fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Shutdown fixedThreadPool");


        } catch (InterruptedException e) {
            System.err.println("Tasks interrupted");
            e.printStackTrace();
        }

    }
}

