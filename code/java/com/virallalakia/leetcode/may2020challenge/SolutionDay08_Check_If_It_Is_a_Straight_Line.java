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
 * Problem: Problem 8 (Check If It Is a Straight Line)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay08_Check_If_It_Is_a_Straight_Line {
  public boolean checkStraightLine(int[][] p) {
    if (p == null || p.length <= 2) {
      return true;
    }
    boolean x0 = (p[0][0] == p[1][0]);
    if (x0) {
      for (int[] a : p) {
        if (a[0] != p[0][0]) {
          return false;
        }
      }
      return true;
    }
    boolean y0 = (p[0][1] == p[1][1]);
    if (y0) {
      for (int[] a : p) {
        if (a[1] != p[0][1]) {
          return false;
        }
      }
      return true;
    }
    int xd = (p[1][0] - p[0][0]);
    int yd = (p[1][1] - p[0][1]);
    for (int[] a : p) {
      if ((a[1] - p[0][1]) * xd != (a[0] - p[0][0]) * yd) {
        return false;
      }
    }
    return true;
  }
}
