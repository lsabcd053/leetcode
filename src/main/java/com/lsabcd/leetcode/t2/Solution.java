package com.lsabcd.leetcode.t2;

import com.lsabcd.leetcode.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1T = l1;
        ListNode l2T = l2;
        int sum = 0;
        int up = 0;

        ListNode l1TPre = null;
        ListNode l2TPre = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            if (up == 1) {
                sum ++;
            }
            if (sum > 9) {
                up = 1;
                l1.val = sum % 10;
                l2.val = sum % 10;
            } else {
                up = 0;
                l1.val = sum;
                l2.val = sum;
            }
            l1TPre = l1;
            l2TPre = l2;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode result = null;
        ListNode pre = null;
        if (l1 == null && l2 == null) {
            result = l1T;
            pre = l1TPre;
            if (up == 1) {
                ListNode last = new ListNode(1);
                pre.next = last;
            }
            return result;
        }

        if (l2 == null) {
            result = l1T;
            processLast(l1,up);
        }
        if (l1 == null) {
            result = l2T;
            processLast(l2,up);
        }
        return result;

    }

    private void processLast(ListNode node,int up){
        if (up == 0) {
            return;
        }
        if (node.val + up > 9 && node.next != null) {
            node.val = 0;
            processLast(node.next,1);
        } else if (node.val + up <= 9) {
            node.val = node.val + up;
        }else {
            node.val = 0;
            ListNode last = new ListNode(1);
            node.next = last;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l3;

        ListNode resp = s.addTwoNumbers(l1,l2);
        while (resp != null) {
            System.out.println(resp.val);
            resp = resp.next;
        }
    }
}
