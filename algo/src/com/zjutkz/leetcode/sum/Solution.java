package com.zjutkz.leetcode.sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kangzhe on 19/5/28.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int numA = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int numB = nums[j];
                if(numA + numB == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}