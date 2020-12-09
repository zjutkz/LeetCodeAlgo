package com.zjutkz.leetcode.android.list;

public class ReverseBetween {

    private static ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode newHead = reverseBetween(head, 2, 4);

        Helper.print(newHead);
    }

    private static ListNode reverseBetween(ListNode head, int start, int end) {
        if (start == 1) {
            return reverseN(head, end);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, start - 1, end - 1);
        return head;
    }

    private static ListNode reverseN(ListNode head, int index) {
        successor = head.next;
        int i = index -1;
        while (i > 0) {
            successor = successor.next;
            --i;
        }

        return doReverse(head, index);
    }

    private static ListNode doReverse(ListNode head, int index) {
        if(index == 1) {
            return head;
        }
        ListNode last = doReverse(head.next, index - 1);
        head.next.next = head;
        head.next = successor;

        return last;
    }
}
