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
 * Problem: Problem 11 (Flood Fill)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay11_Flood_Fill {
  public int[][] floodFill(int[][] arr, int ri, int ci, int c) {
    if (arr == null || arr.length == 0 || arr[0].length == 0) {
      return arr;
    }

    boolean[][] fArr = new boolean[arr.length][arr[0].length];
    markFill(arr, fArr, ri, ci, arr[ri][ci]);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (fArr[i][j]) {
          arr[i][j] = c;
        }
      }
    }
    return arr;
  }

  private void markFill(int[][] arr, boolean[][] fArr, int ri, int ci, int c) {
    if (ri < 0 || ri >= arr.length || ci < 0 || ci >= arr[0].length) {
      return;
    }
    if (fArr[ri][ci] || arr[ri][ci] != c) {
      return;
    }
    fArr[ri][ci] = true;
    markFill(arr, fArr, ri - 1, ci, c);
    markFill(arr, fArr, ri, ci - 1, c);
    markFill(arr, fArr, ri, ci + 1, c);
    markFill(arr, fArr, ri + 1, ci, c);
  }
}
