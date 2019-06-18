package com.zjutkz.leetcode.roman_to_int;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kangzhe on 19/6/18.
 */
public class Solution {

    public int romanToInt(String input) {
        Map<String,Integer> map = new HashMap<>();

        map.put("", 0);

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);

        map.put("X", 10);
        map.put("XX", 20);
        map.put("XXX", 30);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("LX", 60);
        map.put("LXX", 70);
        map.put("LXXX", 80);
        map.put("XC", 90);

        map.put("C", 100);
        map.put("CC", 200);
        map.put("CCC", 300);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("DC", 600);
        map.put("DCC", 700);
        map.put("DCCC", 800);
        map.put("CM", 900);

        map.put("M", 1000);
        map.put("MM", 2000);
        map.put("MMM", 3000);

        if(map.containsKey(input)) {
            return map.get(input);
        }

        int answer = 0;
        for(int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));
            if(i == input.length() - 1 || "M".equals(letter)) {
                answer = answer + map.get(letter);
            } else {
                String nextLetter = String.valueOf(input.charAt(i + 1));
                if("I".equals(letter) && ("V".equals(nextLetter) || "X".equals(nextLetter))) {
                    answer = answer - 1;
                } else if("X".equals(letter) && ("L".equals(nextLetter) || "C".equals(nextLetter))) {
                    answer = answer - 10;
                } else if("C".equals(letter) && ("D".equals(nextLetter) || "M".equals(nextLetter))) {
                    answer = answer - 100;
                } else {
                    answer = answer + map.get(letter);
                }
            }
        }

        return answer;
    }
}
