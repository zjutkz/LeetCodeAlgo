package com.zjutkz.leetcode.median;

/**
 * Created by kangzhe on 19/6/3.
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int mid1 = 0,mid2 = 0;
        for (int k = 0, i = 0, j = 0; k <= n / 2 ; k++) {
            mid1 = mid2;
            if (i == nums1.length){
                mid2 = nums2[j++];
            }else if (j == nums2.length){
                mid2 = nums1[i++];
            }else if (nums1[i] < nums2[j]){
                mid2 = nums1[i++];
            }else{
                mid2 = nums2[j++];
            }
        }
        return (n % 2 == 1 ? mid2 / 1.0 : (mid1 + mid2) / 2.0);
    }
}
