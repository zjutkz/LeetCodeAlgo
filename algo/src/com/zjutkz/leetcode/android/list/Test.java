package com.zjutkz.leetcode.android.list;

/**
 * Created by kangzhe on 19/5/30.
 */
public class Test {

    //头插法：
    //1. 将node的next指向head，node->head(1)
    //2. 将head变成node，head=node，创建出head(2)，既将链表变成head(2)->head(1)
    //3. 返回head(2)
    private static ListNode appendNodeHead(ListNode head, int data) {
        ListNode node = new ListNode(data);

        node.next = head;
        head = node;

        return head;
    }

    //尾插法：
    //1. 如果head为空，则说明node是第一个节点，直接将node赋值给head
    //2. 如果head不为空，则循环找到最后一个节点tail，并将tail的next赋值给node，tail->node
    //3. 返回head
    private static ListNode appendNodeTail(ListNode head, int data) {
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

    //翻转链表：
    //采用递归的方式翻转
    //1. 如果当前node没有next，则说明遍历到了最后一个节点tail，结束翻转
    //2. 如果当前的入参没有prev，则说明是第一次遍历，既当前的node节点为head，则将它的next设置为空，变成tail
    //3. 如果既不是head也不是tail，则说明是中间节点，将它的next指向prev，完成单个节点的翻转
    //4. 将当前节点node当做prev，当前节点node的next作为当前节点进行递归，完成整个链表的翻转
    private static void reverseNode(ListNode prev, ListNode curr) {
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
