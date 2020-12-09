package com.zjutkz.leetcode.android.string;

// https://developer.aliyun.com/article/73485
public class PermutationNew {

    public static void main(String[] args){
        String str = "abc";
        char[] chArr = str.toCharArray();

        list(chArr, 0, chArr.length - 1);
    }

    private static void list(char[] chArr, int head, int tail) {
        if(head >= tail) {
            System.out.println(chArr);
            return ;
        }

        for(int i = head; i <= tail; i++) {
            swap(chArr, head, i);
            list(chArr, head + 1, tail);
            swap(chArr, head, i);
        }
    }

    private static void swap(char[] chArr, int pre, int next) {
        char temp = chArr[pre];
        chArr[pre] = chArr[next];
        chArr[next] = temp;
    }
}
