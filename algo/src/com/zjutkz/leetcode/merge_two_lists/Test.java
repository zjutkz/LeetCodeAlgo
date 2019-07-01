package com.zjutkz.leetcode.merge_two_lists;

/**
 * Created by kangzhe on 19/7/1.
 */
public class Test {

    public static void main(String[] args) {
        ListNode l1Head = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1Head.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2Head = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2Head.next = l2_2;
        l2_2.next = l2_3;

        ListNode answer = new Solution().mergeTwoLists(l1Head, l2Head);
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
