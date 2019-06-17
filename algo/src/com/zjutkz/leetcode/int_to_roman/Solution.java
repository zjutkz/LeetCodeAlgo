package com.zjutkz.leetcode.int_to_roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kangzhe on 19/6/17.
 */
public class Solution {
    public String intToRoman(int input) {
        Map<Integer,String> map = new HashMap<>();

        map.put(0, "");

        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");

        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");

        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");

        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");

        String inputStr = String.valueOf(input);
        if(inputStr.length() == 1) {
            return map.get(Integer.parseInt(inputStr));
        } else if(inputStr.length() == 2) {
            String ten = map.get(Integer.parseInt(inputStr.substring(0, 1)) * 10);
            String one = map.get(Integer.parseInt(inputStr.substring(1, 2)));
            return String.format("%s%s", ten, one);
        } else if(inputStr.length() == 3) {
            String hundred = map.get(Integer.parseInt(inputStr.substring(0, 1)) * 100);
            String ten = map.get(Integer.parseInt(inputStr.substring(1, 2)) * 10);
            String one = map.get(Integer.parseInt(inputStr.substring(2, 3)));
            return String.format("%s%s%s", hundred, ten, one);
        } else {
            String thousand = map.get(Integer.parseInt(inputStr.substring(0, 1)) * 1000);
            String hundred = map.get(Integer.parseInt(inputStr.substring(1, 2)) * 100);
            String ten = map.get(Integer.parseInt(inputStr.substring(2, 3)) * 10);
            String one = map.get(Integer.parseInt(inputStr.substring(3, 4)));
            return String.format("%s%s%s%s", thousand, hundred, ten, one);
        }
    }
}
