package com.zjutkz.leetcode.android.pm.lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// https://juejin.im/entry/6844903486895865864

public class Test {
    private static List<Integer> list = new ArrayList<>();
    private static final int FULL = 10;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        Test test2 = new Test();
        new Thread(test2.new Producer()).start();
        //new Thread(test2.new Producer()).start();
        //new Thread(test2.new Producer()).start();
        //new Thread(test2.new Producer()).start();

        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
//        new Thread(test2.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("生产者" + Thread.currentThread().getName() + "  等待锁");
                    lock.lock();
                    System.out.println("生产者" + Thread.currentThread().getName() + "  获得锁");
                    while(list.size() == FULL) {
                        System.out.println("生产者" + Thread.currentThread().getName() + "  list以达到最大容量，进行wait");
                        notFull.await();
                        System.out.println("生产者" + Thread.currentThread().getName() + "  退出wait");
                    }

                    Thread.sleep(2000);

                    Random random = new Random();
                    int value = random.nextInt();
                    System.out.println("生产者" + Thread.currentThread().getName() + " 生产数据: " + value);

                    list.add(value);
                    notEmpty.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("生产者" + Thread.currentThread().getName() + "  释放锁");
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("消费者" + Thread.currentThread().getName() + "  等待锁");
                    lock.lock();
                    System.out.println("消费者" + Thread.currentThread().getName() + "  获得锁");
                    while(list.size() == 0) {
                        System.out.println("消费者" + Thread.currentThread().getName() + "  list为空，进行wait");
                        notEmpty.await();
                        System.out.println("消费者" + Thread.currentThread().getName() + "  退出wait");
                    }
                    int value = list.remove(0);
                    System.out.println("消费者" + Thread.currentThread().getName() + "  消费数据: " + value);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("消费者" + Thread.currentThread().getName() + "  释放锁");
                }
            }
        }
    }
}