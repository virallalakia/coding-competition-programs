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
 * Problem: Problem 13 (Remove K Digits)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay13_Remove_K_Digits {
  public String removeKdigits(String n, int k) {
    if (n == null || "".equals(n.trim()) || k < 1) {
      return n;
    }
    n = n.trim();
    if (n.replace("0", "").length() <= k) {
      return "0";
    }
    return getByRemovingKDigits(n, k);
  }

  public String getByRemovingKDigits(String n, int k) {
    if (k <= 0) {
      return n;
    }
    int maxI = n.length() - 1;
    for (int i = 0; i < n.length() - 1; i++) {
      if (n.charAt(i) > n.charAt(i + 1)) {
        maxI = i;
        break;
      }
    }
    if (maxI == 0) {
      maxI = 1;
      for (int i = 1; i < n.length(); i++) {
        if (n.charAt(i) != '0') {
          maxI = i;
          break;
        }
      }
      return getByRemovingKDigits(n.substring(maxI), k - 1);
    }
    return getByRemovingKDigits(n.substring(0, maxI) + n.substring(maxI + 1), k - 1);
  }
}
