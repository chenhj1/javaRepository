package com.chj.thread;

/**
 * 两个线程交替打印1212
 */
public class Test {
    public static void main(String []args){
        final Object o = new Object();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    synchronized (o){
                        try {
                            o.notify();
                            o.wait();
                            System.out.println(1);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true){
                    synchronized (o){
                        try {
                            o.notify();
                            System.out.println(2);
                            o.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
