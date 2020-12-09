package com.zjutkz.leetcode.android.string;

// https://developer.aliyun.com/article/73485
public class Permutation {

    public static void main(String[] args){
        String str = "abc";
        char[] chArr = str.toCharArray();

        list(chArr, 0, chArr.length - 1);
    }

    private static void list(char[] chArr, int from, int to) {
        if(from >= to) {
            System.out.println(chArr);
            return ;
        }

        for(int i = from; i <= to; i++) {
            swap(chArr, from, i);
            list(chArr, from + 1, to);
            swap(chArr, from, i);
        }
    }

    private static void swap(char[] chArr, int from, int to) {
        char temp = chArr[from];
        chArr[from] = chArr[to];
        chArr[to] = temp;
    }
}
