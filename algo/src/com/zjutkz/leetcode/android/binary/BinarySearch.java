package com.zjutkz.leetcode.android.binary;

//https://juejin.im/post/6844903616629702669

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,7,9,11,19,30};
        System.out.println(binarySearchRecursion(arr, 33, 0, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > key) {
                high = mid - 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearchRecursion(int[] arr, int key, int low, int high) {
        if(low >= high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(arr[mid] > key) {
            return binarySearchRecursion(arr, key, low, mid - 1);
        } else if(arr[mid] < key) {
            return binarySearchRecursion(arr, key, mid + 1, high);
        } else {
            return mid;
        }
    }
}
