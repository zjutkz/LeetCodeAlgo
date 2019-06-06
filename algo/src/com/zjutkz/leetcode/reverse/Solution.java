package com.zjutkz.leetcode.reverse;

/**
 * Created by kangzhe on 19/6/6.
 */
public class Solution {

    public int reverse(int input) {
        if(input == 0) {
            return 0;
        }
        boolean negative = input < 0;
        String inputStr = String.valueOf(input);
        if(negative) {
            inputStr = inputStr.substring(1, inputStr.length());
        }
        char[] arr = inputStr.toCharArray();
        for(int i = 0;i < arr.length / 2; i++) {
            char head = arr[i];
            char tail = arr[arr.length - i - 1];
            arr[i] = tail;
            arr[arr.length - i - 1] = head;
        }
        String answer = String.valueOf(arr);
        try {
            if(!negative) {
                return Integer.parseInt(answer);
            } else {
                return 0 - Integer.parseInt(answer);
            }
        }catch (NumberFormatException e) {
            return 0;
        }
    }
}
