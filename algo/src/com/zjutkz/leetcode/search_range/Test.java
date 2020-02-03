package com.zjutkz.leetcode.search_range;

/**
 * Created by kangzhe on 19/7/29.
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] answer = new Solution().searchRange(nums, 6);
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}
