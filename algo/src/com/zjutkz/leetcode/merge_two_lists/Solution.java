package com.zjutkz.leetcode.merge_two_lists;

/**
 * Created by kangzhe on 19/7/1.
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;

        while(l1 != null || l2 != null) {
            if(l1 == null) {
               while(l2 != null) {
                   head = appendNodeTail(head, l2.val);
                   l2 = l2.next;
               }
            } else if(l2 == null) {
                while(l1 != null) {
                    head = appendNodeTail(head, l1.val);
                    l1 = l1.next;
                }
            } else {
                int l1Val = l1.val;
                int l2Val = l2.val;
                if(l1Val < l2Val) {
                    head = appendNodeTail(head, l1.val);
                    l1 = l1.next;
                } else {
                    head = appendNodeTail(head, l2.val);
                    l2 = l2.next;
                }
            }
        }

        return head;
    }

    private ListNode appendNodeTail(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        } else {
            ListNode tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

        return head;
    }
}
