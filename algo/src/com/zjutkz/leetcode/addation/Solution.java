package com.zjutkz.leetcode.addation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangzhe on 19/5/29.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            carry /= 10;
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            dummy.next = new ListNode(carry % 10);
            dummy = dummy.next;
        }

        if (carry / 10 == 1)
            dummy.next = new ListNode(1);
        return ans.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        List<Integer> sum = new ArrayList<>();
//
//        while(l1 != null) {
//            if(l2 != null) {
//                int l1Val = l1.val;
//                int l2Val = l2.val;
//                int sumVal = l1Val + l2Val >= 10 ? 0 : l1Val + l2Val;
//
//                l1 = l1.next;
//                l2 = l2.next;
//
//                if(l1 != null || l2 != null) {
//                    if(l1 == null || l2 == null) {
//                        sum.add(sumVal);
//                    } else {
//                        int l1NextVal = l1.val;
//                        int l2NextVal = l2.val;
//
//                        int addOne = l1NextVal + l2NextVal >= 10 ? 1 : 0;
//
//                        sum.add(sumVal + addOne);
//                    }
//                } else {
//                    sum.add(sumVal);
//                }
//            } else {
//                sum.add(l1.val);
//
//                l1 = l1.next;
//            }
//        }
//
//        while (l2 != null) {
//            sum.add(l2.val);
//            l2 = l2.next;
//        }
//
//        ListNode answer = new ListNode(sum.get(0));
//        for(int i = 1; i < sum.size(); i++) {
//            answer = appendNode(answer, sum.get(i));
//        }
//
//        return answer;
//    }

    private ListNode appendNode(ListNode head, int data) {
        ListNode node = new ListNode(data);

        node.next = head;
        head = node;

        return head;
    }
}
