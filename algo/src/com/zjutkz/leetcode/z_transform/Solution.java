package com.zjutkz.leetcode.z_transform;

/**
 * Created by kangzhe on 19/6/5.
 */
public class Solution {

    public String convert(String input, int numRows) {
        if(input.length() <= 2 || numRows <= 1) {
            return input;
        }
        StringBuilder answer = new StringBuilder();

        int length = input.length();
        String[][] arr = zTransform(input, numRows);

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < length; j++) {
                if(arr[i][j] != null) {
                    answer.append(arr[i][j]);
                }
            }
        }

        return answer.toString();
    }

    private String[][] zTransform(String input, int numRows) {
        int lastIndex = 0;
        int lastNum = 0;
        int length = input.length();
        String[][] arr = new String[numRows][length];

        for(int i = 0; i < length; i++) {
            if(i == 0 || i - lastIndex + 1 == numRows) {
                lastIndex = i;
                for(int j = 0; j < numRows; j++) {
                    int index = i * 2 + j;
                    if(index >= length) {
                        return arr;
                    }
                    arr[j][i] = String.valueOf(input.charAt(index));
                    if(j == numRows - 1) {
                        lastNum = index;
                    }
                }
            } else {
                int column = numRows - (i - lastIndex) - 1;
                int index = lastNum + (numRows - column - 1);
                if(index >= length) {
                    return arr;
                }
                arr[column][i] = String.valueOf(input.charAt(index));
            }
        }
        return arr;
    }
}
