package com.zjutkz.leetcode.android.list;

public class FindCenter {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seven = new ListNode(7);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seven;

        //int length = length(head);
        //ListNode center = center(head, length / 2);
        ListNode center = centerEnhance(head);

        Helper.printSingle(center);
    }

    private static ListNode centerEnhance(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }

        return  length;
    }

    public static ListNode center(ListNode head, int centerIndex) {
        while (centerIndex > 0) {
            --centerIndex;
            head = head.next;
        }

        return head;
    }
}
