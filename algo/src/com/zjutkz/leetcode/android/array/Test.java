package com.zjutkz.leetcode.android.array;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
        reorder(arr, arr.length);
        for(int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void reorder(int array[], int length)
    {
        int low = 0, high = length - 1;
        int temp;
        while (low < high)
        {
            while (array[low] < 0 && low < high)
                low++;
            while (array[high] > 0 && low < high)
                high--;
            temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
    }
}
