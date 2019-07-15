package com.zjutkz.leetcode.remove_element;

/**
 * Created by kangzhe on 19/7/11.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            if(nums[0] == val) {
                return 0;
            }
            return 1;
        }

        int removeCount = 0;
        int originLength = nums.length;
        for(int i = 0; i < originLength; i++) {
            if(i >= nums.length) {
                return nums.length;
            }
            int num = nums[i - removeCount];
            if(num == val) {
                for(int j = i; j < nums.length - 1; j++) {
                    nums[j - removeCount] = nums[j + 1 - removeCount];
                }
                ++removeCount;
            }
        }

        return nums.length - removeCount;
    }
}
