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
 * Problem: Problem 9 (Valid Perfect Square)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay09_Valid_Perfect_Square {
  public boolean isPerfectSquare(int n) {
    int i = 0;
    for (i = 0; i * i < n && i * i >= 0; i++) {
    }
    return (i * i == n);
  }
}
