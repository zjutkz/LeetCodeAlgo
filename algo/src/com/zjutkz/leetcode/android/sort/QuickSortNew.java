package com.zjutkz.leetcode.android.sort;

import java.util.concurrent.locks.ReentrantReadWriteLock;

// https://www.jianshu.com/p/6a02a657abcb
public class QuickSortNew {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        quickSort(arr, 0, arr.length - 1);
        for(int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void quickSort(int[] arr, int head, int tail) {
         if(head >= tail) {
             return ;
         }

         int pivot = pivot(arr, head, tail);

         quickSort(arr, head, pivot - 1);
         quickSort(arr, pivot + 1, tail);
    }

    private static int pivot(int[] arr, int head, int tail) {
        int base = arr[tail];
        while (head < tail) {
            while (head < tail && arr[head] < base) {
                ++head;
            }
            if(head < tail) {
                swap(arr, head, tail);
                --tail;
            }

            while (head < tail && arr[tail] > base) {
                --tail;
            }
            if(head < tail) {
                swap(arr, head, tail);
                ++head;
            }
        }

        return head;
    }

    private static void swap(int[] arr, int pre, int next) {
        int temp = arr[pre];
        arr[pre] = arr[next];
        arr[next] = temp;
    }


}
