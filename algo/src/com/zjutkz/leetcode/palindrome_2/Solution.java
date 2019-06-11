package com.zjutkz.leetcode.palindrome_2;

/**
 * Created by kangzhe on 19/6/11.
 */
public class Solution {

    public boolean isPalindrome(int input) {
        if(input >= 0 && input < 10) {
            return true;
        }
        String inputStr = String.valueOf(input);
        int length = inputStr.length();
        boolean isOdd = (length % 2) == 1;
        int max = isOdd ? length / 2 : (length / 2) - 1;
        for(int i = 0; i <= max; i++) {
            if(i == max) {
                return isOdd || inputStr.charAt(i) == inputStr.charAt(i + 1);
            }
            if(inputStr.charAt(i) != inputStr.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
