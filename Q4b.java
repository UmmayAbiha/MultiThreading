package com.practice.Multithreading;

import java.io.FileNotFoundException;


class Runnable1 implements Runnable {

    @Override
    public void run() {
            System.out.println(

                    Thread.currentThread().getName()
                            + ", executing run() method!");
            try {
                throw new FileNotFoundException();
            }
            catch (FileNotFoundException e) {
                System.out.println("Must catch here!");

                e.printStackTrace();
            }
            int rem = 1 / 0;

    }
}

