package com.zjutkz.leetcode.remove_duplicates;

/**
 * Created by kangzhe on 19/7/9.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }

        int removedCount = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int pre = nums[i - removedCount];
            int next = nums[i + 1 - removedCount];
            if(pre == next) {
                for(int j = i; j < nums.length - 1; j++) {
                    nums[j - removedCount] = nums[j + 1 - removedCount];
                }
                ++removedCount;
            }
        }

        return nums.length - removedCount;
    }
}
