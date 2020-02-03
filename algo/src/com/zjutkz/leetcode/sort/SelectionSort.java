package com.zjutkz.leetcode.sort;

import java.util.Arrays;

/**
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/
 * Created by kangzhe on 20/2/3.
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){    //选出之后待排序中值最小的位置
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];      //交换操作
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }
}
