package com.zjutkz.leetcode.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kangzhe on 19/6/20.
 */
public class Solution {

    //没考虑去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[k]);
                        answers.add(answer);
                    }
                }
            }
        }

        return answers;
    }
}
