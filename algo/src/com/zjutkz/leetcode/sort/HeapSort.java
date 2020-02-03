package com.zjutkz.leetcode.sort;

import java.util.Arrays;

/**
 * https://zhuanlan.zhihu.com/p/46680658
 * Created by kangzhe on 20/2/3.
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        int len = arr.length;
        //创建堆，从最后一个非叶子结点开始
        //最后一个叶子节点的索引值是n-1,它的父节点索引值是[(n-1)-1]/2 = n/2 -1
        for(int i = len/2 - 1; i>=0; i--){
            maxHeapify(arr, i, len-1);
        }

        //堆排序
        for(int i = len-1; i>0; i--){
            swap(arr, arr[0], arr[i]);
            maxHeapify(arr, 0, i-1);
        }
    }

    private static void maxHeapify(int arr[], int start, int end){
        int dad = start;
        int max_son = start * 2 +1;
        while(max_son <= end){
            if(max_son + 1 <=end && arr[max_son] < arr[max_son + 1]){
                max_son++;
            }

            if(arr[max_son] > arr[dad]){
                swap(arr, arr[max_son], arr[dad]);
                dad = max_son;
                max_son = dad*2 + 1;
            }else{
                return ;
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
        heapSort(arr);
    }
}
