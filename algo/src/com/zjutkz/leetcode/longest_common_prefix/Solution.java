package com.zjutkz.leetcode.longest_common_prefix;

/**
 * Created by kangzhe on 19/6/19.
 */
public class Solution {

    public String longestCommonPrefix(String[] input) {
        if(input == null || input.length == 0) {
            return "";
        }

        String minStr = input[0];
        for(String str : input) {
            if(str == null) {
                return "";
            }
            if(str.length() < minStr.length()) {
                minStr = str;
            }
        }

        for(int i = minStr.length(); i >= 0; i--) {
            String subStr = minStr.substring(0, i);
            boolean matched = true;
            for(String str : input) {
                if(!str.startsWith(subStr)) {
                    matched = false;
                }
            }
            if(matched) {
                return subStr;
            }
        }

        return "";
    }
}
