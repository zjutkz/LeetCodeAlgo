package com.zjutkz.leetcode.three_sum_closest;

import java.util.Arrays;

/**
 * Created by kangzhe on 19/6/23.
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Integer answer = null;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length ; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int numA = nums[i];
                int numB = nums[left];
                int numC = nums[right];
                if(numA + numB + numC == target) {
                    return target;
                } else if(numA + numB + numC < target) {
                    if(answer == null) {
                        answer = numA + numB + numC;
                    }
                    if(Math.abs(target - (numA + numB + numC)) < Math.abs(target - answer)) {
                        answer = numA + numB + numC;
                    }
                    ++left;
                } else {
                    if(answer == null) {
                        answer = numA + numB + numC;
                    }
                    if(Math.abs(target - (numA + numB + numC)) < Math.abs(target - answer)) {
                        answer = numA + numB + numC;
                    }
                    --right;
                }
            }
        }

        return answer;
    }
}
