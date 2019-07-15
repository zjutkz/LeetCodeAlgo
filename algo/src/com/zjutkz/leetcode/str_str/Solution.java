package com.zjutkz.leetcode.str_str;

/**
 * Created by kangzhe on 19/7/15.
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0) {
            if(needle == null || needle.length() == 0) {
                return 0;
            }
            return -1;
        }
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        for(int i = 0;i < haystack.length(); i++) {
            String ch = String.valueOf(haystack.charAt(i));
            if(ch.equals(String.valueOf(needle.charAt(0)))) {
                if(needle.length() == 1) {
                    return i;
                }
                for(int j = 1; j < needle.length(); j++) {
                    if(i + j == haystack.length()) {
                        return -1;
                    }
                    if(!String.valueOf(haystack.charAt(i + j)).equals(String.valueOf(needle.charAt(j)))) {
                        break;
                    }
                    if(j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
