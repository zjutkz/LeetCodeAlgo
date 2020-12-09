package com.zjutkz.leetcode.android.list;

public class ReverseN {

    private static ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        //ListNode third = new ListNode(3);
        //ListNode fourth = new ListNode(4);
        //ListNode fifth = new ListNode(5);
        //ListNode sixth = new ListNode(6);

        head.next = second;
        //second.next = third;
        //third.next = fourth;
        //fourth.next = fifth;
        //fifth.next = sixth;

        ListNode newHead = reverseN(head, 2);

        Helper.print(newHead);
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
