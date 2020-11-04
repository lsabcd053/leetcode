package com.lsabcd.leetcode.t206;

import com.lsabcd.leetcode.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode pre = null;
        ListNode next = current.next;
        while (null != current) {
            current.next = pre;
            pre = current;
            current = next;
            if (next!=null){
                next = next.next;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next = null;

        Solution s = new Solution();
        ListNode r = s.reverseList(h1);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;

        }

    }

}
