package com.github.cwdtom.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * @author chenweidong
 */
public class AddTwoNumbers2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            int adv = 0;
            ListNode tail = head;
            while (l1 != null || l2 != null || adv != 0) {
                int i1 = l1 == null ? 0 : l1.val;
                int i2 = l2 == null ? 0 : l2.val;
                int sum = i1 + i2 + adv;
                adv = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            return head.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
