package com.zjutkz.leetcode.max_area;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by kangzhe on 19/6/13.
 */
public class Solution {

    public int maxArea(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int answer = 0;
        for(int i = 0; i < height.length; i++) {
            int point1 = height[i];
            for(int j = 0; j < height.length; j++) {
                int point2 = height[j];
                answer = Math.max(answer, Math.min(point1, point2) * Math.abs(i - j));
            }
        }

        return answer;
    }
}
