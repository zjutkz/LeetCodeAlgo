package com.zjutkz.leetcode.android.sort;

/**
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 * Created by kangzhe on 20/2/3.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j + 1]) {
                    Helper.swap(arr, j, j + 1);
                }
            }
        }
        Helper.print(arr);
    }
}
