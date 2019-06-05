package com.zjutkz.leetcode.z_transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangzhe on 19/6/6.
 */
public class BetterSolution {

    public String convert(String input, int numRows) {

        if (numRows == 1) return input;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, input.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : input.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
