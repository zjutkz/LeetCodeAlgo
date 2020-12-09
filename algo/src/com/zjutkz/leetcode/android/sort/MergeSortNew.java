package com.zjutkz.leetcode.android.sort;

public class MergeSortNew {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 3, 11, 1};
        mergeSort(arr, 0, arr.length - 1);
        for(int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void mergeSort(int[] arr, int head, int tail) {
        if(head >= tail) {
            return ;
        }

        int mid = head + (tail - head) / 2;

        mergeSort(arr, head, mid);
        mergeSort(arr, mid + 1, tail);

        merge(arr, head, mid , tail);
    }

    private static void merge(int[] arr, int head, int mid, int tail) {
        int[] result = new int[tail - head + 1];
        int firstStart = head;
        int secondStart = mid + 1;
        int index = 0;

        while (firstStart <= mid & secondStart <= tail) {
            if(arr[firstStart] < arr[secondStart]) {
                result[index++] = arr[firstStart++];
            } else {
                result[index++] = arr[secondStart++];
            }
        }

        if(firstStart <= mid) {
            while (firstStart <= mid) {
                result[index++] = arr[firstStart++];
            }
        } else if(secondStart <= tail) {
            while (secondStart <= tail) {
                result[index++] = arr[secondStart++];
            }
        }

        System.arraycopy(result, 0, arr, head, tail - head + 1);
    }
}
