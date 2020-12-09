package com.zjutkz.leetcode.android.pm.synchroned;

import java.util.ArrayList;
import java.util.List;

// https://www.jianshu.com/p/6768e8ee66e0

public class Test {

    private static final Object LOCK = new Object();

    private static List<Integer> holder = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer(), "consumer-1").start();
        new Thread(new Consumer(), "consumer-2").start();
        new Thread(new Consumer(), "consumer-3").start();
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (holder.size() > 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    holder.add(1);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOCK.notifyAll();
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (holder.size() == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = holder.remove(0);
                    System.out.println("consume: " + value);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LOCK.notify();
                }
            }
        }
    }
}
