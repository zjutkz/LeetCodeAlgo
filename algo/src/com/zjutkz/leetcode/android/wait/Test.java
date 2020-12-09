package com.zjutkz.leetcode.android.wait;

public class Test {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " enter synchronized block...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        while (true) {
                            System.out.println(Thread.currentThread().getName() + " enter synchronized block...");
                            lock.notify();
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + " after notify...");
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "thread-b");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (lock) {
                            System.out.println(Thread.currentThread().getName() + " enter synchronized block...");
                            lock.notify();
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + " after notify...");
                            lock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-c");

        a.start();
        b.start();
        c.start();
    }
}
