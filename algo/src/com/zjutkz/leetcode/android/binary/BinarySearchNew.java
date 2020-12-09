package com.zjutkz.leetcode.android.binary;

public class BinarySearchNew {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 12));
    }

    private static int binarySearch(int[] arr, int head, int tail, int target) {
        if(head > tail) {
            return -1;
        }

        int mid = head + (tail - head) / 2;
        if(arr[mid] < target) {
            return binarySearch(arr, mid + 1, tail, target);
        } else if(arr[mid] > target) {
            return binarySearch(arr, head, mid - 1, target);
        } else {
            return mid;
        }
    }
}
