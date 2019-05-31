package com.zjutkz.leetcode.longest_str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kangzhe on 19/5/30.
 */
public class BetterWindowSolution {

    public int lengthOfLongestSubstring(String input) {
        int n = input.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(input.charAt(j))){
                set.add(input.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(input.charAt(i++));
            }
        }
        return ans;
    }
}
