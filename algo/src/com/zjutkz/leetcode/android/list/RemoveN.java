package com.zjutkz.leetcode.android.list;

public class RemoveN {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        //int length = length(head);
        //removeN(head, 2, length);
        removeNEnhance(head, 3);

        Helper.print(head);
    }

    private static void removeNEnhance(ListNode head, int i) {
        ListNode fast = head;
        ListNode slow = head;

        while (i > 0) {
            --i;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        remove(slow);
    }

    public static int length(ListNode head) {
        int length = 0;

        while(head != null) {
            ++length;
            head = head.next;
        }

        return length;
    }

    public static void removeN(ListNode head, int index, int length) {
        int forIndex = 0;
        ListNode removeNode = null;
        while(head != null) {
            if(forIndex == length - index) {
                removeNode = head;
                break;
            }
            ++forIndex;
            head = head.next;
        }
        if(removeNode != null) {
            remove(removeNode);
        }
    }

    public static void remove(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
