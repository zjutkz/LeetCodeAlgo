package com.zjutkz.leetcode.longest_valid_parentheses;

import java.util.Stack;

/**
 * Created by kangzhe on 19/7/23.
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    answer = Math.max(answer, i - stack.peek());
                }
            }
        }
        return answer;
    }
}
