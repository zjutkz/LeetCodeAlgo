package com.zjutkz.leetcode.android.pm.deque;

import java.util.concurrent.BlockingDeque;

public enum Producer {

    INSTANCE;

    private BlockingDeque<Integer> blockingDeque;

    public void setQueue(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    public void produce(int value) {
        try {
            blockingDeque.put(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
