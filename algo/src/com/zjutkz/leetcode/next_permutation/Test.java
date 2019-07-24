package com.zjutkz.leetcode.next_permutation;

/**
 * Created by kangzhe on 19/7/22.
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        new Solution().nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
