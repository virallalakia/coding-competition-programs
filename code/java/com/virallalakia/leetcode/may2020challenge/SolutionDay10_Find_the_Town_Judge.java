/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.may2020challenge;

import java.util.HashMap;
import java.util.Map;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 10 (Find the Town Judge)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay10_Find_the_Town_Judge {
  public int findJudge(int n, int[][] t) {
    if (t == null || t.length == 0 || t.length < n - 1) {
      return (n == 1 ? n : -1);
    }
    Map<Integer, Integer> map = new HashMap<>(n);
    for (int i = 1; i <= n; i++) {
      map.put(i, (n * (n + 1)) / 2);
    }
    for (int[] tt : t) {
      map.remove(tt[0]);
      Integer ti = map.get(tt[1]);
      if (ti != null) {
        map.put(tt[1], ti - tt[0]);
      }
    }
    if (map.size() == 1) {
      for (Integer k : map.keySet()) {
        if ((int) k == map.get(k)) {
          return k;
        }
      }
    }
    return -1;
  }
}
