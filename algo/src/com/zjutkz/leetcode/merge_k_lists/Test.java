package com.zjutkz.leetcode.merge_k_lists;

/**
 * Created by kangzhe on 19/7/3.
 */
public class Test {

    public static void main(String[] args) {
        ListNode l1Head = new ListNode(1);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(5);
        l1Head.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2Head = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2Head.next = l2_2;
        l2_2.next = l2_3;

        ListNode l3Head = new ListNode(2);
        l3Head.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1Head, l2Head, l3Head};

        ListNode answer = new Solution().mergeKLists(lists);
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
