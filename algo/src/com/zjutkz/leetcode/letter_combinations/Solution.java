package com.zjutkz.leetcode.letter_combinations;

import java.util.*;

/**
 * Created by kangzhe on 19/6/24.
 */
public class Solution {

    private List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits == null || "".equals(digits)) {
            return answer;
        }

        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < digits.length(); i++) {
            String ch = String.valueOf(digits.charAt(i));
            list.add(map.get(ch));
        }

        combine("", list);

        return answer;
    }

    private void combine(String output, List<List<String>> list) {
        if(list.size() == 0) {
            answer.add(output);
        } else {
            List<String> letters = list.get(0);
            List<List<String>> newList = new ArrayList<>();
            for(int j = 1; j < list.size(); j++) {
                newList.add(list.get(j));
            }
            for(int k = 0; k < letters.size(); k++) {
                combine(output + letters.get(k), newList);
            }
        }
    }
}