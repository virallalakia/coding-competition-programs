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
 * Problem: Problem 2 (Jewels and Stones)
 * Result: Pass
 * Year: 2020
 */

public class SolutionDay02_Jewels_and_Stones {
  public int numJewelsInStones(String J, String S) {
    if (J == null || S == null || "".equals(J) || "".equals(S)) {
      return 0;
    }

    int r = 0;
    for (int i = 0; i < S.length(); i++) {
      if (J.contains(S.substring(i, i + 1))) {
        r++;
      }
    }
    return r;
  }
}
