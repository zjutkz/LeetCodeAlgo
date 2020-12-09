package com.zjutkz.leetcode.android.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Hungry implements Serializable {

    private static Hungry instance = new Hungry();

    public static Hungry getInstance() {
        return instance;
    }

    private Hungry() {
        throw new RuntimeException("cannot get instance from reflect!");
    }

    private Object readResolve() {
        return instance;
    }
}
