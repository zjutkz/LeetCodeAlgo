package com.zjutkz.leetcode.find_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kangzhe on 19/7/18.
 */
public class Solution {

    public List<Integer> findSubstring(String input, String[] words) {
        Map<String,Integer> letterCount = new HashMap<>();
        for(String word : words) {
            if(letterCount.containsKey(word)) {
                letterCount.put(word, letterCount.get(word) + 1);
            } else {
                letterCount.put(word, 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        if(input == null || input.length() == 0) {
            return answer;
        }
        if(words == null || words.length == 0) {
            return answer;
        }
        int letterNum = words.length;
        int letterLength = words[0].length();
        int totalLength = letterLength * letterNum;
        if(input.length() < totalLength) {
            return answer;
        }
        for(int i = 0; i < input.length() - totalLength + 1; i++) {
            String subString = input.substring(i, i + totalLength);
            Map<String,Integer> copy = new HashMap<>();
            for(String word : letterCount.keySet()) {
                copy.put(word, letterCount.get(word));
            }
            if(match(subString, words, copy, letterLength)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean match(String subString, String[] words, Map<String, Integer> letterCount, int letterLength) {
        for(String word : words) {
            boolean matched = false;
            for(int i = 0; i < subString.length() - letterLength + 1; i = i + letterLength) {
                String sub = subString.substring(i, i + letterLength);
                if(word.equals(sub)) {
                    matched = true;
                    if(i == subString.length() - letterLength) {
                        subString = subString.substring(0, i);
                    } else if(i == 0) {
                        subString = subString.substring(letterLength, subString.length());
                    } else {
                        String prefix = subString.substring(0, i);
                        String suffix = subString.substring(i + letterLength, subString.length());
                        subString = prefix + suffix;
                    }
                    letterCount.put(word, letterCount.get(word) - 1);
                    break;
                }
            }
            if(!matched) {
                return false;
            }
        }

        for(String word : letterCount.keySet()) {
            if(letterCount.get(word) > 0) {
                return false;
            }
        }
        return true;
    }
}
