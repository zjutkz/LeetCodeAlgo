package com.zjutkz.leetcode.android.list;

public class Helper {

    public static void print(ListNode head) {
        while (head != null) {
            if(head.next == null) {
                System.out.println(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

    public static void printSingle(ListNode head) {
        System.out.println(head.val);
    }
}
