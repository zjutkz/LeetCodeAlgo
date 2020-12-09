package com.zjutkz.leetcode.android.list;

public class Sort {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(0);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        sort(head);

        Helper.print(head);
    }

    public static void sort(ListNode head) {

    }
}
