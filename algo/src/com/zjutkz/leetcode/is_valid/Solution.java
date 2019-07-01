package com.zjutkz.leetcode.is_valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kangzhe on 19/6/27.
 */
public class Solution {

    public boolean isValid(String input) {
        if(input == null || "".equals(input)) {
            return true;
        }

        Map<String,String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));
            if(stack.empty()) {
                stack.push(ch);
            } else {
                String top = stack.peek();
                if(map.containsValue(ch)){
                    stack.push(ch);
                } else {
                    if(map.get(ch).equals(top)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }
}
