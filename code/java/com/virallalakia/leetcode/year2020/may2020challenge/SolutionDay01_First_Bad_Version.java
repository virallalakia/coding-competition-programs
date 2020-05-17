/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.year2020.may2020challenge;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 1 (First Bad Version)
 * Result: Pass
 * Year: 2020
 */

public class SolutionDay01_First_Bad_Version extends VersionControl {
  public int firstBadVersion(int n) {
    if (n < 1) {
      return 0;
    }
    return binSearch(1, n);
  }

  private int binSearch(int a, int b) {
    int m = a + (b - a) / 2;
    if (isBadVersion(m)) {
      if (a >= m) {
        return a;
      }
      int t = binSearch(a, m - 1);
      if (t > 0) {
        return t;
      }
      return m;
    } else {
      if (m >= b) {
        return 0;
      }
      return binSearch(m + 1, b);
    }
  }
}

class VersionControl {
  boolean isBadVersion(final int m) {
    return true;
  }
}
