package com.zjutkz.leetcode.search_insert;

/**
 * Created by kangzhe on 19/7/30.
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            if(nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }

        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int middle = (start + end) / 2;
            if(nums[middle] == target) {
                return middle;
            }
            if(nums[middle] < target) {
                start = middle + 1;
            }
            if(nums[middle] > target) {
                end = middle - 1;
            }
        }
        return start;
    }
}
