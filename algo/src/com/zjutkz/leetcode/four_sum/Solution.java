package com.zjutkz.leetcode.four_sum;

import java.util.*;

/**
 * Created by kangzhe on 19/6/25.
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int numA = nums[i];
            for(int j = i + 1; j < nums.length - 2; j++) {
                int numB = nums[j];

                int low = j + 1;
                int high = nums.length - 1;

                while(low < high) {
                    int numC = nums[low];
                    int numD = nums[high];

                    if(numA + numB + numC + numD == target) {
                        List<Integer> hit = new ArrayList<>();
                        hit.add(numA);
                        hit.add(numB);
                        hit.add(numC);
                        hit.add(numD);
                        Collections.sort(hit);
                        answer.add(hit);

                        while (j < nums.length - 2 && nums[j + 1] == nums[j]) ++j;
                        while(low < high && nums[low + 1] == nums[low]) ++low;
                        while(low < high && nums[high - 1] == nums[high]) --high;

                        ++low;
                        --high;
                    } else if(numA + numB + numC + numD < target) {
                        while(low < high && nums[low + 1] == nums[low]) ++low;
                        ++low;
                    } else {
                        while(low < high && nums[high - 1] == nums[high]) --high;
                        --high;
                    }
                }
            }
        }

        return answer;
    }
}
