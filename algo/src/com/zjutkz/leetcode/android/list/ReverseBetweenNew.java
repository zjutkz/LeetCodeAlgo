package com.zjutkz.leetcode.android.list;

public class ReverseBetweenNew {

    private static ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        //ListNode fourth = new ListNode(4);
        //ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        //third.next = fourth;
        //fourth.next = fifth;

        ListNode newHead = reverseBetween(head, 1, 3);

        Helper.print(newHead);
    }

    private static ListNode reverseBetween(ListNode head, int start, int end) {
        if(start == end) {
            return head;
        }

        int i = start;
        ListNode startNode = head;

        while (i > 1) {
            startNode = startNode.next;
            --i;
            --end;
        }

        ListNode node = reverseN(startNode, end);
        if(node.next == head || node.next == null || node == head) {
            return node;
        } else {
            head.next = node;
            return head;
        }
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
