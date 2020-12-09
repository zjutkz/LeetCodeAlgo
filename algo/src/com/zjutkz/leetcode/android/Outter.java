package com.zjutkz.leetcode.android;

public class Outter {

    static {
        System.out.println("outter static block...");
    }

    static class Inner {
        static {
            System.out.println("inner static block...");
        }
    }
}
