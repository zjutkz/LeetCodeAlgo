package com.zjutkz.leetcode.android.list;

public class Circle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        //fifth.next = second;

        System.out.println(circle(head));
    }

    public static boolean circle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if(fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }
}
