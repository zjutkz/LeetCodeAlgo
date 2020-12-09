package com.zjutkz.leetcode.android.string;

public class Prefix {

    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(arr));
    }

    public static String findLongestCommonPrefixVertical(String[] arr) {
        for(int i = 0; i < arr[0].length(); i++) {
            char index = arr[0].charAt(i);
            for(String param : arr) {
                if(i == param.length()) {
                    return arr[0].substring(0, i);
                }
                if(param.charAt(i) != index) {
                    return arr[0].substring(0, i);
                }
            }
        }
        return arr[0];
    }

    public static String findLongestCommonPrefix(String[] arr) {
        String shortest = arr[0];
        for(String param : arr) {
            if(shortest.length() > param.length()) {
                shortest = param;
            }
        }
        for(int i = shortest.length(); i > 0; i--) {
            String prefix = shortest.substring(0, i);
            boolean matched = true;
            for(String param : arr) {
                if(!param.contains(prefix)) {
                    matched = false;
                }
            }
            if(matched) {
                return prefix;
            }
        }
        return "";
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
