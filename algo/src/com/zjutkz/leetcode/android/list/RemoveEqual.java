package com.zjutkz.leetcode.android.list;

public class RemoveEqual {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        removeEqual(head);

        Helper.print(head);
    }

    public static void removeEqual(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (first != null) {
            ListNode next = first.next;
            if(next == null) {
                break;
            }
            if(next.val == first.val) {
                second = next;
                while (second != null) {
                    ListNode equalNext = second.next;
                    if(equalNext == null) {
                        break;
                    }
                    if(equalNext.val == second.val) {
                        second = equalNext;
                    } else {
                        break;
                    }
                }
                first.next = second.next;
                first = first.next;
            } else {
                first = first.next;
            }
        }
    }
}
