package com.zjutkz.leetcode.android.string;

public class HuiWenNew {

    public static void main(String[] args) {
        System.out.println(isPalindromePlus(12321));
        System.out.println(getHuiWen(""));
    }

    private static String getHuiWen(String str) {
        String longest = "";
        for(int i = 0; i < str.length(); i++) {
            String huiwen1 = huiwen(str, i, i);
            String huiwen2 = huiwen(str, i, i + 1);

            longest = longest.length() > huiwen1.length() ? longest : huiwen1;
            longest = longest.length() > huiwen2.length() ? longest : huiwen2;
        }

        return longest;
    }

    private static String huiwen(String str, int start, int end) {
        while (start >= 0 && end < str.length()) {
            if (str.charAt(start) != str.charAt(end)) {
                break;
            } else {
                --start;
                ++end;
            }
        }

        return str.substring(start + 1, end);
    }


    private static boolean isPalindromePlus(int num) {
        if(num < 0) {
            return false;
        }
        int div = 1;
        while (num / div > 1) {
            div = div * 10;
        }

        while (num > 0) {
            int left = num / div;
            int right = num % 10;
            if(left != right) {
                return false;
            }
            num = (num % div) / 10;
            div = div / 100;
        }

        return true;
    }
}
