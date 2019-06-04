package com.zjutkz.leetcode.palindrome;

/**
 * Created by kangzhe on 19/6/4.
 */
//https://www.zhihu.com/question/40965749
//https://segmentfault.com/a/1190000003914228
//https://blog.csdn.net/u013309870/article/details/70742315
public class Solution {

    private String answer = "";
    private int maxLength = 0;

    public String longestPalindrome(String input) {
        int length = input.length();
        if(length == 0) {
            return "";
        }
        if(length == 1) {
            return input;
        }
        for(int i = 0; i < length; i++) {
            check(input, i, i);
            check(input, i, i + 1);
        }

        return answer;
    }

    private void check(String input, int low, int high) {
        while (low >= 0 && high < input.length()) {
            if(input.charAt(low) == input.charAt(high)) {
                if(high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    answer = input.substring(low, high + 1);
                }
                --low;
                ++high;
            } else {
                break;
            }
        }
    }
}
