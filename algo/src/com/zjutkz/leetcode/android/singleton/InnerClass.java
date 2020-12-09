package com.zjutkz.leetcode.android.singleton;

import java.io.Serializable;

public class InnerClass implements Serializable {

    public static InnerClass getInstance() {
        return Holder.instance;
    }

    private static class Holder {

        private static InnerClass instance = new InnerClass();
    }

    private Object readResolve() {
        return Holder.instance;
    }
}
