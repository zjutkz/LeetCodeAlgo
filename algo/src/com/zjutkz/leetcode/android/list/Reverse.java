package com.zjutkz.leetcode.android.list;

import java.util.Stack;

public class Reverse {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        ListNode newHead = reverseByRecurse(head);

        Helper.print(newHead);
    }

    // https://www.jianshu.com/p/bd6a64d36916
    // 保存当前头结点的下个节点。
    // 将当前头结点的下一个节点指向“上一个节点”，这一步是实现了反转。
    // 将当前头结点设置为“上一个节点”。
    // 将保存的下一个节点设置为头结点。
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    // https://zhuanlan.zhihu.com/p/86745433
    private static ListNode reverseByRecurse(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
