package com.zjutkz.leetcode.android.string;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args){
        String str = "abc";
        //combination(str.toCharArray());
        //System.out.println("=========");
        combination2(str.toCharArray(), "", 0);
    }

    // https://developer.aliyun.com/article/73485
    private static void combination2(char[] src, String str, int pos) {
        if(pos == src.length) {
            System.out.println(str);
            return ;
        }

        combination2(src, str, pos + 1);
        combination2(src, str + src[pos], pos + 1);
    }

    // https://my.oschina.net/u/4265623/blog/4316540
    private static void combination(char chs[]){
        if(chs == null || chs.length == 0){
            return ;
        }
        List<Character> list = new ArrayList();
        for(int i = 1; i <= chs.length; i++){
            combine(chs, 0, i, list);
        }
    }
    //从字符数组中第begin个字符开始挑选number个字符加入list中
    private static void combine(char []cs,int begin,int number,List<Character> list){
        if(number == 0){
            System.out.println(list.toString());
            return ;
        }
        if(begin == cs.length){
            return;
        }
        list.add(cs[begin]);
        combine(cs, begin + 1, number - 1, list);
        list.remove((Character)cs[begin]);
        combine(cs, begin + 1, number, list);
    }
}
