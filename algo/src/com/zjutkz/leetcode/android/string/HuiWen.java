package com.zjutkz.leetcode.android.string;

public class HuiWen {

    public static void main(String[] args) {
        System.out.println(isPalindromePlus(123216));
    }

    private static String judgeHuiWhen(String str) {
        String huiwen = "";

        for(int i = 1; i < str.length(); i++) {
            String h1 = getHuiWen(str, i, i);
            String h2 = getHuiWen(str, i, i + 1);

            huiwen = huiwen.length() > h1.length() ? huiwen : h1;
            huiwen = huiwen.length() > h2.length() ? huiwen : h2;
        }

        return huiwen;
    }

    private static String getHuiWen(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if(str.charAt(left) != str.charAt(right)) {
                break;
            }
            --left;
            ++right;
        }
        return str.substring(left + 1, right);
    }

    private static boolean isHuiWen(String str) {
        for(int i = 0; i < str.length(); i++) {
            char head = str.charAt(i);
            char tail = str.charAt(str.length() - i - 1);
            if(head != tail) {
                return false;
            }
        }

        return true;
    }

    // https://segmentfault.com/a/1190000000453441
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int reverse = 0;
        int value = x;

        while (value > 0) {
            reverse = reverse * 10 + value % 10;
            value = value / 10;
        }

        return reverse == x;
    }


    // https://segmentfault.com/a/1190000000453441
    public static boolean isPalindromePlus(int x) {
        if(x < 0) {
            return false;
        }

        int temp = x;
        int div = 1;

        while (temp / div > 10) {
            div = div * 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if(left != right) {
                return false;
            }

            x = (x % div) / 10;
            div = div / 100;
        }

        return true;
    }
}
