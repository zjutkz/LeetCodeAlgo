package com.zjutkz.leetcode.android.string;

public class Sub {

    public static void main(String[] args) {
        String[] arr = new String[]{"abbaceee", "crthbbad88hg", "4456ebbaffkr"};

        System.out.println(longestCommonSub(arr));
    }

    public static String longestCommonSub(String[] arr) {
        String shortest = arr[0];
        for(String param : arr) {
            if(shortest.length() > param.length()) {
                shortest = param;
            }
        }

        for(int i = shortest.length(); i > 0; i--) {
            String sub = shortest.substring(0, i);
            boolean matched = true;
            for(int j = 1; j < arr.length; j++) {
                if(!arr[j].contains(sub)) {
                    matched = false;
                }
            }
            if(matched) {
                return sub;
            }
        }

        return "";
    }
}
