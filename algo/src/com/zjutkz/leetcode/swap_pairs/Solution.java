package com.zjutkz.leetcode.swap_pairs;

/**
 * Created by kangzhe on 19/7/7.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            ListNode answer = head.next;
            swap(head);
            return answer;
        }

        int count = 0;
        ListNode answer = null;

        while (head.next != null) {
            if(count % 2 == 0) {
                if(count == 0) {
                    answer = head.next;
                }
                head = swap(head);
            } else {
                if(head.next.next == null) {
                    break;
                }
                ListNode temp = head.next;
                head.next = head.next.next;
                head = temp;
            }
            ++count;
        }

        return answer;
    }

    private ListNode swap(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        next.next = node;

        return node;
    }
}
