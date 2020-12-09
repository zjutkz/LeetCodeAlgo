package com.zjutkz.leetcode.android.sort;

/**
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 * Created by kangzhe on 20/2/3.
 */
public class ShellSort {

    public static void shellSort(int[] arr){
        int initGap = arr.length / 2;
        for(int gap = initGap; gap > 0; gap = gap / 2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                while (j > 0 && arr[j] < arr[j - gap]) {
                    Helper.swap(arr, j, j - gap);
                    j = j - gap;
                }
            }
        }
        Helper.print(arr);
    }
}
