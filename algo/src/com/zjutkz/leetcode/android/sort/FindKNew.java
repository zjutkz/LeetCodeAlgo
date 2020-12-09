package com.zjutkz.leetcode.android.sort;

public class FindKNew {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findK(arr, 0, arr.length - 1, 2));
    }

    private static int findK(int[] arr, int head, int tail, int index) {
        int pivot = pivot(arr, head, tail);

        if(pivot == index -1) {
            return arr[pivot];
        } else if(pivot > index - 1) {
            return findK(arr, head, pivot - 1, index);
        } else {
            return findK(arr, pivot + 1, tail, index);
        }
    }

    private static int pivot(int[] arr, int head, int tail) {
        int base = arr[tail];

        while (head < tail) {
            while (head < tail && arr[head] > base) {
                ++head;
            }
            if (head < tail) {
                swap(arr, head, tail);
                --tail;
            }

            while (head < tail && arr[tail] < base) {
                --tail;
            }
            if(head < tail) {
                swap(arr, head, tail);
                ++head;
            }
        }

        return head;
    }

    private static void swap(int[] arr, int head, int tail) {
        int temp = arr[head];
        arr[head] = arr[tail];
        arr[tail] = temp;
    }
}
