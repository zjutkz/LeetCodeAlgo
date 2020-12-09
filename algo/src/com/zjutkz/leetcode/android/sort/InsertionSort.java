package com.zjutkz.leetcode.android.sort;

/**
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/
 * Created by kangzhe on 20/2/3.
 */
public class InsertionSort {

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    Helper.swap(arr, i, j);
                }
            }
        }
        Helper.print(arr);
    }
}
