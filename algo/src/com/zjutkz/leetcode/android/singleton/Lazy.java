package com.zjutkz.leetcode.android.singleton;

import java.io.Serializable;

public class Lazy implements Serializable {

    private static volatile Lazy instance;

    public static Lazy getInstance() {
        if(instance == null) {
            synchronized (Lazy.class) {
                if(instance == null) {
                    instance = new Lazy();
                }
            }
        }

        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
