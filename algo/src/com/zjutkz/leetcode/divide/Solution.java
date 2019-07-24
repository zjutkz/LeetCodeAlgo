package com.zjutkz.leetcode.divide;

/**
 * Created by kangzhe on 19/7/17.
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1) {
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        int count = 0;
        long remain = Math.abs((long) dividend);
        while (remain >= Math.abs(divisor)) {
            remain = remain - Math.abs(divisor);
            ++count;
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -count;
        }
        return count;
    }
}
