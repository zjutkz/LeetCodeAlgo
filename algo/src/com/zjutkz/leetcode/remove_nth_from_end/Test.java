package com.zjutkz.leetcode.remove_nth_from_end;

/**
 * Created by kangzhe on 19/6/26.
 */
public class Test {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode answer = new Solution().removeNthFromEnd(node1, 1);

        while (answer != null) {
            System.out.print(answer.val + (answer.next == null ? "" : "->"));
            answer = answer.next;
        }
    }
}
