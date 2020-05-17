"""
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
"""

"""
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 12 (Single Element in a Sorted Array)
 * Result: Pass
 * Year: 2020
"""

class Solution:
  def singleNonDuplicate(self, n: List[int]) -> int:
    if len(n) == 1:
      return n[0]
    for i in range(0, len(n) - 1, 2):
      if n[i] != n[i+1]:
        return n[i]
    return n[-1]
