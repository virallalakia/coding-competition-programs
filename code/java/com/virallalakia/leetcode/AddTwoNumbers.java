/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Add Two Numbers problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 * 
 * @author Viral Lalakia 
 */
public class AddTwoNumbers {

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  // ======== submission start ========
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode();
    ListNode ansHead = ans;
    int carry = 0;
    while (l1 != null || l2 != null) {
      ans.next = new ListNode(carry);
      ans = ans.next;
      if (l1 != null) {
        ans.val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        ans.val += l2.val;
        l2 = l2.next;
      }
      carry = ans.val / 10;
      ans.val %= 10;
    }
    if (carry > 0) {
      ans.next = new ListNode(carry);
    }
    return ansHead.next;
  }
  // ======== submission end ========
}
