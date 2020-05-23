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
 * Problem: Problem 21 (Count Square Submatrices with All Ones)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay21_Count_Square_Submatrices_with_All_Ones {
  public int countSquares(int[][] arr) {
    int R = 0;
    int max = Math.min(arr.length, arr[0].length);
    int[][] DP = new int[arr.length][arr[0].length];
    for (int r = 0; r < arr.length; r++) {
      for (int c = 0; c < arr[0].length; c++) {
        R += arr[r][c];
        DP[r][c] = arr[r][c];
      }
    }
    for (int t = 1; t < max; t++) {
      for (int r = 0; r < arr.length - t; r++) {
        for (int c = 0; c < arr[0].length - t; c++) {
          if (DP[r][c] == 0) {
            continue;
          }
          for (int tt = 0; tt < t; tt++) {
            DP[r][c] += arr[r+tt][c+t] + arr[r+t][c+tt];
          }
          DP[r][c] += arr[r+t][c+t];
          if (DP[r][c] == (t+1) * (t+1)) {
            R++;
          } else {
            DP[r][c] = 0;
          }
        }
      }
    }
    return R;
  }
}
