"""
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
"""

"""
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 16 (Odd Even Linked List)
 * Result: Pass
 * Year: 2020
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
  def oddEvenList(self, h1: ListNode) -> ListNode:
    if (h1 != None and h1.next != None and h1.next.next != None):
      t = h1
      t2 = h2 = h1.next
      while t2 != None and t2.next != None:
        t.next = t2.next
        t = t.next
        t2.next = t.next
        t2 = t2.next
      t.next = h2
    return h1
