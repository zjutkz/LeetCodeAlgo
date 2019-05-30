package com.zjutkz.leetcode.addation;

/**
 * Created by kangzhe on 19/5/29.
 */
public class Test {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);

        ListNode node2 = new ListNode(5);

        ListNode answer = new Solution().addTwoNumbers(node1, node2);
        while (answer.next != null) {
            System.out.print(String.format("%s -> ", String.valueOf(answer.val)));
            answer = answer.next;
        }
        System.out.print(answer.val);
    }
}
