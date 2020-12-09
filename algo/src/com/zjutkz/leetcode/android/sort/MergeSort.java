package com.zjutkz.leetcode.android.sort;

/**
 * https://juejin.im/post/5d25a6d3f265da1b80206e4e
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/#%E5%85%AD%E3%80%81%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%EF%BC%88Quick-Sort%EF%BC%89
 * Created by kangzhe on 20/2/3.
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param a 待排序的数组
     * @param n 数组大小
     */
    public static void mergeSort(int[] a, int n) {
        mergeSortRecursion(a, 0, n - 1);
    }

    /**
     * 递归调用的函数
     *
     * @param a
     * @param p
     * @param r
     */
    public static void mergeSortRecursion(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的位置q
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortRecursion(a, p, q);
        mergeSortRecursion(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 合并两个有序数组
     *
     * @param a 合并好的有序数组，需要放到这个位置上。
     * @param p
     * @param q
     * @param r
     */
    public static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

        // 最少把一个数组中的数据取完。
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据。
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据copy到临时数组 tmp。
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将 tmp 中的数据拷贝回 a 中
        System.arraycopy(tmp, 0, a, p, r - p + 1);
    }
}
