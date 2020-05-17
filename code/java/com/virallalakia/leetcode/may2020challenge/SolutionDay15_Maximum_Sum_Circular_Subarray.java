/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.may2020challenge;

import java.util.Arrays;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 15 (Maximum Sum Circular Subarray)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay15_Maximum_Sum_Circular_Subarray {
  public int maxSubarraySumCircular(int[] arr) {
    int max1 = kadane(arr, false);
    int max2 = Arrays.stream(arr).sum() + kadane(arr, true);
    if (max2 == 0) {
      return max1;
    }
    return Math.max(max1, max2);
  }

  private int kadane(int[] arr, boolean rev) {
    int cur = (rev ? -arr[0] : arr[0]);
    int max = cur;
    for (int i = 1; i < arr.length; i++) {
      cur = Math.max(0, cur) + (rev ? -arr[i] : arr[i]);
      max = Math.max(max, cur);
    }
    return max;
  }
}
