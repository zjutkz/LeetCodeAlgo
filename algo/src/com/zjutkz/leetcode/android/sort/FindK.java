package com.zjutkz.leetcode.android.sort;

public class FindK {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findK(arr, 0, arr.length - 1, 2));
    }

    private static int findK(int[] arr, int head, int tail, int k) {
        int pivot = pivot(arr, head, tail);

        if(pivot == k - 1) {
            return arr[pivot];
        } else if(pivot > k - 1) {
            return findK(arr, head, pivot - 1, k);
        } else if(pivot < k - 1){
            return findK(arr, pivot + 1, tail, k);
        }
        return 0;
    }

    private static int pivot(int[] arr, int head, int tail) {
        int base = arr[tail];

        while (head < tail) {
            while (head < tail && arr[head] > base) {
                ++head;
            }
            if(head < tail) {
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

    private static void swap(int[] arr, int pre, int next) {
        int temp = arr[pre];
        arr[pre] = arr[next];
        arr[next] = temp;
    }
}
