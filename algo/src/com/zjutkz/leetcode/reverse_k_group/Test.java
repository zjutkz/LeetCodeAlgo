package com.zjutkz.leetcode.reverse_k_group;

/**
 * Created by kangzhe on 19/7/8.
 */
public class Test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode answer = new Solution().reverseKGroup(head, 3);
        while (answer != null) {
            if(answer.next == null) {
                System.out.print(answer.val);
            } else {
                System.out.print(answer.val + "->");
            }
            answer = answer.next;
        }
    }
}
