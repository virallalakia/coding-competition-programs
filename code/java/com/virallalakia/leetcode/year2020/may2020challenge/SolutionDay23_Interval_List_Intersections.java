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
 * Problem: Problem 23 (Interval List Intersections)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay23_Interval_List_Intersections {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<Integer> t1 = new ArrayList<>();
    List<Integer> t2 = new ArrayList<>();
    for (int i = 0, j = 0; i < A.length && j < B.length;) {
      if (A[i][1] < B[j][0]) {
        i++;
      } else if (B[j][1] < A[i][0]) {
        j++;
      } else {
        t1.add(Math.max(A[i][0], B[j][0]));
        t2.add(Math.min(A[i][1], B[j][1]));
        if (A[i][1] == B[j][1]) {
          i++;
          j++;
        } else if (A[i][1] < B[j][1]) {
          i++;
        } else {
          j++;
        }
      }
    }
    int[][] R = new int[t1.size()][2];
    for (int i = 0; i < R.length; i++) {
      R[i][0] = t1.get(i);
      R[i][1] = t2.get(i);
    }
    t1 = t2 = null;
    return R;
  }
}
