package com.zjutkz.leetcode.android.sort;

/**
 * https://www.jianshu.com/p/6a02a657abcb
 * Created by kangzhe on 20/2/3.
 */
public class QuickSort {

    public static void quickSort(int arr[]) {
        doSort(arr, 0, arr.length - 1);
        Helper.print(arr);
    }

    private static void doSort(int[] arr, int head, int tail) {
        if(head >= tail) {
            return ;
        }

        int partitionIndex = partition(arr, head, tail);
        doSort(arr, head, partitionIndex - 1);
        doSort(arr, partitionIndex + 1, tail);
    }

    private static int partition(int[] arr, int head, int tail) {
        int first = arr[head];

        int i = head;
        int j = tail;

        while(i < j) {
            while (arr[j] >= first && i < j) {
                --j;
            }
            while (arr[i] <= first && i < j) {
                ++i;
            }
            Helper.swap(arr, i, j);
        }

        Helper.swap(arr, head, i);

        return i;
    }
}
