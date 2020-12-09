package com.zjutkz.leetcode.android.pm.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {

    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();

        Producer.INSTANCE.setQueue(queue);
        Consumer.INSTANCE.setQueue(queue);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    if(i % 3 == 0) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Producer.INSTANCE.produce(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("before consume...");
                    System.out.println("consume: " + Consumer.INSTANCE.consume());
                    System.out.println("after consume...");
                }
            }
        }).start();
    }
}
