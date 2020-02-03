package com.zjutkz.leetcode.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 * Created by kangzhe on 20/2/3.
 */
public class ShellSort {

    public static void shellSort(int[] arr){
        //增量gap，并逐步缩小增量
        for(int gap = arr.length / 2;gap > 0;gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap;i < arr.length;i++){
                int j = i;
                while(j-gap >= 0 && arr[j] < arr[j-gap]){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
        }
    }

    public static void swap(int []arr,int a,int b){
        int temp = arr[b];      //交换操作
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }
}
