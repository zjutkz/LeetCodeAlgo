package com.zjutkz.leetcode.android.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    lock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " get read lock...");
                    Thread.sleep(1000);
                    lock.readLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " release read lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    lock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " get read lock...");
                    Thread.sleep(1000);
                    lock.readLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " release read lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + " get write lock...");
                    Thread.sleep(10000);
                    lock.writeLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " release write lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    lock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + " get write lock...");
                    Thread.sleep(5000);
                    lock.writeLock().unlock();
                    System.out.println(Thread.currentThread().getName() + " release write lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-4").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    lock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " get read lock...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-5").start();
    }
}
