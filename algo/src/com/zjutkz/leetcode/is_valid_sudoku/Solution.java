package com.zjutkz.leetcode.is_valid_sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kangzhe on 19/8/13.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> numSet = new HashSet<>();
        for(int row = 0; row < 9; row++) {
            numSet.clear();
            for(int column = 0; column < 9; column ++) {
                if(!String.valueOf(board[row][column]).equals(".") && numSet.contains(board[row][column])) {
                    return false;
                } else {
                    numSet.add(board[row][column]);
                }
            }
        }
        numSet.clear();
        for(int row = 0; row < 9; row++) {
            numSet.clear();
            for(int column = 0; column < 9; column ++) {
                if(!String.valueOf(board[column][row]).equals(".") && numSet.contains(board[column][row])) {
                    return false;
                } else {
                    numSet.add(board[column][row]);
                }
            }
        }
        numSet.clear();
        for(int row = 0; row < 9; row = row + 3) {
            for(int column = 0; column < 9; column = column + 3) {
                numSet.clear();

                if(!String.valueOf(board[column][row]).equals(".") && numSet.contains(board[column][row])) {
                    return false;
                } else {
                    numSet.add(board[column][row]);
                }
                if(!String.valueOf(board[column + 1][row]).equals(".") && numSet.contains(board[column + 1][row])) {
                    return false;
                } else {
                    numSet.add(board[column + 1][row]);
                }
                if(!String.valueOf(board[column + 2][row]).equals(".") && numSet.contains(board[column + 2][row])) {
                    return false;
                } else {
                    numSet.add(board[column + 2][row]);
                }
                if(!String.valueOf(board[column + 1][row + 1]).equals(".") && numSet.contains(board[column + 1][row + 1])) {
                    return false;
                } else {
                    numSet.add(board[column + 1][row + 1]);
                }
                if(!String.valueOf(board[column + 2][row + 1]).equals(".") && numSet.contains(board[column + 2][row + 1])) {
                    return false;
                } else {
                    numSet.add(board[column + 2][row + 1]);
                }
                if(!String.valueOf(board[column][row + 1]).equals(".") && numSet.contains(board[column][row + 1])) {
                    return false;
                } else {
                    numSet.add(board[column][row + 1]);
                }
                if(!String.valueOf(board[column][row + 2]).equals(".") && numSet.contains(board[column][row + 2])) {
                    return false;
                } else {
                    numSet.add(board[column][row + 2]);
                }
                if(!String.valueOf(board[column + 1][row + 2]).equals(".") && numSet.contains(board[column + 1][row + 2])) {
                    return false;
                } else {
                    numSet.add(board[column + 1][row + 2]);
                }
                if(!String.valueOf(board[column + 2][row + 2]).equals(".") && numSet.contains(board[column + 2][row + 2])) {
                    return false;
                } else {
                    numSet.add(board[column + 2][row + 2]);
                }
            }
        }

        return true;
    }
}
