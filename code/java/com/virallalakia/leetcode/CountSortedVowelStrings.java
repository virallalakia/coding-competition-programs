/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Count Sorted Vowel Strings problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 *
 * @author Viral Lalakia
 */
public class CountSortedVowelStrings {
  // ======== submission start ========
  public int countVowelStrings(int n) {
    int[][] DP = new int[n + 1][5];
    DP[1] = new int[] {1, 1, 1, 1, 1};
    for (int ni = 2; ni <= n; ni++) {
      DP[ni] = new int[] {0, 0, 0, 0, 1};
      DP[ni][0] = DP[ni - 1][0] + DP[ni - 1][1] + DP[ni - 1][2] + DP[ni - 1][3] + DP[ni - 1][4];
      DP[ni][1] = DP[ni - 1][1] + DP[ni - 1][2] + DP[ni - 1][3] + DP[ni - 1][4];
      DP[ni][2] = DP[ni - 1][2] + DP[ni - 1][3] + DP[ni - 1][4];
      DP[ni][3] = DP[ni - 1][3] + DP[ni - 1][4];
    }
    int count = 0;
    for (int i = 0; i < 5; i++) {
      count += DP[n][i];
    }
    return count;
  }
  // ======== submission end ========
}
