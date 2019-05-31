package com.zjutkz.leetcode.longest_str;

import java.util.*;

/**
 * Created by kangzhe on 19/5/30.
 */
public class Solution {

    public int lengthOfLongestSubstring(String input) {
        int answer = 0;
        for(int i = 0; i < input.length(); i++) {
            for(int j = i + 1; j <= input.length(); j++) {
                String testStr = input.substring(i, j);
                if(isUnique(testStr) && answer < (j - i)) {
                    answer = j - i;
                }
            }
        }

        return answer;
    }

    private boolean isUnique(String input) {
        for(int i = 0; i < input.length(); i++) {
            String ch = input.substring(i, i + 1);
            if(input.indexOf(ch) != input.lastIndexOf(ch)) {
                return false;
            }
        }

        return true;
    }
}
