package com.zjutkz.leetcode.remove_nth_from_end;

/**
 * Created by kangzhe on 19/6/26.
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = reverseNode(null, head);

        if(n == 1) {
            ListNode temp = tail.next;
            tail.next = null;
            tail = temp;
        } else {
            ListNode node = null;
            ListNode remove = tail;
            for(int i = 0; i < n - 1; i++) {
                if(i == n - 2) {
                    node = remove;
                }
                remove = remove.next;
            }
            node.next = remove.next;
        }

        if(tail == null) {
            return null;
        }
        return reverseNode(null, tail);
    }

    private ListNode reverseNode(ListNode prev, ListNode curr) {
        ListNode next = curr.next;
        if (next == null) {
            curr.next = prev;
            return curr;
        }

        if (prev == null) {
            curr.next = null;
        } else {
            curr.next = prev;
        }
        return reverseNode(curr, next);
    }
}
