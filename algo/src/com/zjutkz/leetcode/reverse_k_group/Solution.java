package com.zjutkz.leetcode.reverse_k_group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangzhe on 19/7/8.
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        int listLength = getListLength(head);
        if(head.next == null || listLength < k) {
            return head;
        }

        int tail = listLength % k;
        int count = 0;
        List<ListNode> nodeList = new ArrayList<>();

        while (count < listLength) {
            if(count + tail == listLength) {
                nodeList.add(head);
            } else if(count % k == 0) {
                nodeList.add(subList(head, k));
            }
            ++count;
            head = head.next;
        }

        List<ListNode> newNodeList = new ArrayList<>();
        for(int i = 0; i < nodeList.size(); i++) {
            ListNode listHead = nodeList.get(i);
            ListNode listTail = findK(listHead, k - 1);
            if(listTail != null) {
                reverseNode(null, listHead);
                newNodeList.add(listTail);
            } else {
                newNodeList.add(listHead);
            }
        }

        for(int i = 0; i < newNodeList.size() - 1; i++) {
            ListNode preListHead = newNodeList.get(i);
            ListNode nextListHead = newNodeList.get(i + 1);
            ListNode preListTail = findK(preListHead, k - 1);
            preListTail.next = nextListHead;
        }

        return newNodeList.get(0);
    }

    private ListNode subList(ListNode head, int length) {
        int count = 0;
        ListNode newHead = null;
        while (count < length) {
            newHead = appendNodeTail(newHead, head.val);
            head = head.next;
            ++count;
        }
        return newHead;
    }

    private ListNode appendNodeTail(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        } else {
            ListNode tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

        return head;
    }

    private ListNode findK(ListNode head, int k) {
        int count = 0;
        while (count < k) {
            ++count;
            if(head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    private void reverseNode(ListNode prev, ListNode curr) {
        ListNode next = curr.next;
        if (next == null) {
            curr.next = prev;
            return;
        }

        if (prev == null) {
            curr.next = null;
        } else {
            curr.next = prev;
        }
        reverseNode(curr, next);
    }
}
