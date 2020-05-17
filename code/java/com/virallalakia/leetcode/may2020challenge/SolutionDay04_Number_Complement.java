/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.may2020challenge;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 4 (Number Complement)
 * Result: Pass
 * Year: 2020
 */

public class SolutionDay04_Number_Complement {
  public int findComplement(int n) {
    byte c = 0;
    int r = n;
    while (r > 0) {
      c++;
      r >>= 1;
    }
    return ((1 << c) - 1) ^ n;
  }
}
