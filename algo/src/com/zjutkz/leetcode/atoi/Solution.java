package com.zjutkz.leetcode.atoi;

/**
 * Created by kangzhe on 19/6/10.
 */
public class Solution {

    public int myAtoi(String input) {
        if(input == null) {
            return 0;
        }
        input = input.trim();
        if("".equals(input) || "+".equals(input) || "-".equals(input)) {
            return 0;
        }
        boolean isNegative = input.startsWith("-");
        if(input.startsWith("+") || input.startsWith("-")) {
            input = input.substring(1);
        }
        for(int i = 0;i < input.length(); i++) {
            String character = input.substring(i, i + 1);
            try {
                Integer.parseInt(character);
            } catch (NumberFormatException e) {
                if(i == 0) {
                    return 0;
                }
                input = input.substring(0, i);
                break;
            }
        }
        try {
            if(isNegative) {
                input = "-" + input;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
