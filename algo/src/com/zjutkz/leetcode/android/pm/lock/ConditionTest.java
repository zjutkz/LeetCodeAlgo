package com.zjutkz.leetcode.android.pm.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " before lock...");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " after lock...");

                    Thread.sleep(5000);

                    System.out.println(Thread.currentThread().getName() + " before await...");
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + " after await...");

                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " release lock...");
                }
            }
        }, "thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " before lock...");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " after lock...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " release lock...");
                }
            }
        }, "thread-2").start();
    }
}
