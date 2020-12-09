package com.zjutkz.leetcode.android.sort;

public class Helper {

    protected static void swap(int[] arr, int pre, int next) {
        int tmp = arr[next];
        arr[next] = arr[pre];
        arr[pre] = tmp;
    }

    protected static void print(int[] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
