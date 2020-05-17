"""
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
"""

"""
 * This is a solution for one of the problems for LeetCode Weekly-Contest-189 (May 2020).
 * Competition: LeetCode Weekly-Contest-189 (May 2020)
 * Problem: Problem A (Number of Students Doing Homework at a Given Time)
 * Result: Pass
 * Year: 2020
"""

class Solution:
  def busyStudent(self, s: List[int], e: List[int], q: int) -> int:
    R = 0
    for i in range(0,len(s)):
      if s[i] <= q and q <= e[i]:
        R += 1
    return R
