package com.zjutkz.leetcode.android.pm.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewTest {

    private static final int FULL = 10;
    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(count == FULL) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ++count;
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
