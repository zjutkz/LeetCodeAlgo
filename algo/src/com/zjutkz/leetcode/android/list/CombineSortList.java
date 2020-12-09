package com.zjutkz.leetcode.android.list;

public class CombineSortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(12);

        head.next = second;
        second.next = third;
        third.next = fourth;

        ListNode headTwo = new ListNode(2);
        ListNode secondTwo = new ListNode(4);
        ListNode thirdTwo = new ListNode(9);
        ListNode fourthTwo = new ListNode(16);

        headTwo.next = secondTwo;
        secondTwo.next = thirdTwo;
        thirdTwo.next = fourthTwo;

        ListNode newHead = combine(head, headTwo);

        Helper.print(newHead);
    }

    // https://juejin.im/post/6844903714377957384
    public static ListNode combine(ListNode head, ListNode headTwo) {
        ListNode newHead = null;
        ListNode tail = null;

        if(head.val < headTwo.val) {
            newHead = head;
            head = head.next;
        } else {
            newHead = headTwo;
            headTwo = headTwo.next;
        }

        tail = newHead;

        while (head != null && headTwo != null) {
            if(head.val < headTwo.val) {
                tail.next = head;
                head = head.next;
            } else {
                tail.next = headTwo;
                headTwo = headTwo.next;
            }
            tail = tail.next;
        }

        if(head == null) {
             tail.next = headTwo;
        } else {
            tail.next = head;
        }

        return newHead;
    }
}
