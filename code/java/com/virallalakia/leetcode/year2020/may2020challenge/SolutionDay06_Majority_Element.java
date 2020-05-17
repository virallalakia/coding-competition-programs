/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.year2020.may2020challenge;

import java.util.HashMap;
import java.util.Map;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 6 (Majority Element)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay06_Majority_Element {
  public int majorityElement(int[] n) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i : n) {
      Integer c = m.get(i);
      if (c == null) {
        c = 0;
      }
      if (c >= n.length / 2) {
        return i;
      }
      m.put(i, c + 1);
    }
    return -1; // will never happen as per problem statement
  }
}
