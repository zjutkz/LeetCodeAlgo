package com.zjutkz.leetcode.merge_k_lists;

/**
 * Created by kangzhe on 19/7/3.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        if(lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        ListNode head = mergeTwoLists(lists[0], lists[1]);

        for(int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(lists[i], head);
        }

        return head;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
