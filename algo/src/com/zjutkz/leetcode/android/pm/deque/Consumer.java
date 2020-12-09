package com.zjutkz.leetcode.android.pm.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public enum Consumer {

    INSTANCE;

    private BlockingDeque<Integer> blockingDeque;

    public void setQueue(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    public int consume() {
        int value = -1;
        try {
            value = blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value;
    }
}
