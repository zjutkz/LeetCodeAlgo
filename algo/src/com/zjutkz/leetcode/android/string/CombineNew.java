package com.zjutkz.leetcode.android.string;

import java.util.ArrayList;
import java.util.List;

public class CombineNew {

    public static void main(String[] args){
        String str = "abc";
        //combination(str.toCharArray());
        //System.out.println("=========");
        combination(str.toCharArray(), "", 0);
    }

    private static void combination(char[] chArr, String str, int index) {
        if(index == chArr.length) {
            System.out.println(str);
            return ;
        }

        combination(chArr, str, index + 1);
        combination(chArr, str + chArr[index], index + 1);
    }


}
