package com.practice.Multithreading;

public class Q5 {

    static int exchangeCount=0;
    public static void main(String[] args) throws InterruptedException {
        PenExchange rakesh = new PenExchange("Rakesh", 9);
        PenExchange tarun = new PenExchange("Tarun", 8);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                try{
                    Thread.sleep(8);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                exchangePen(tarun, rakesh);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                try{
                    Thread.sleep(8);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                exchangePen(rakesh,tarun);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total pens for Rakesh : " + rakesh.getTotalPens());
        System.out.println("Total pens for Tarun : " + tarun.getTotalPens());
    }

    public static void exchangePen(PenExchange seller, PenExchange buyer)
    {
        exchangeCount++;
        synchronized(seller.getLock())
        {
            synchronized(buyer.getLock())
            {
                buyer.takePen();
                seller.givePen();

                System.out.println(exchangeCount+". Pen exchanged - "+seller.getName()+" to "+buyer.getName());
            }
        }

    }
}

class PenExchange {
    private Integer totalPens;
    private Object lock;
    String name="";

    public PenExchange(String name, Integer totalPens) {
        this.totalPens = totalPens;
        this.lock = new Object();
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPens() {
        return totalPens;
    }

    public void setTotalPens(Integer totalPens) {
        this.totalPens = totalPens;
    }


    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public void givePen()
    {
        this.totalPens--;
    }

    public void takePen()
    {
        this.totalPens++;
    }
}
