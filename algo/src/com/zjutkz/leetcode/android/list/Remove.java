package com.zjutkz.leetcode.android.list;

public class Remove {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        remove(third);

        Helper.print(head);
    }

    public static void remove(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
