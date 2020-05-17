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
 * Problem: Problem 3 (Ransom Note)
 * Result: Pass
 * Year: 2020
 */

import java.util.HashMap;
import java.util.Map;

public class SolutionDay03_Ransom_Note {
  public boolean canConstruct(String n, String m) {
    if (m == null || n == null || n.length() > m.length()) {
      return false;
    }
    Map<Character, Integer> mMap = new HashMap<>();
    Map<Character, Integer> nMap = new HashMap<>();
    for (char c : m.toCharArray()) {
      if (mMap.get(c) == null) {
        mMap.put(c, 1);
      } else {
        mMap.put(c, mMap.get(c) + 1);
      }
    }
    for (char c : n.toCharArray()) {
      if (nMap.get(c) == null) {
        nMap.put(c, 1);
      } else {
        nMap.put(c, nMap.get(c) + 1);
      }
    }
    for (char c : nMap.keySet()) {
      Integer nI = nMap.get(c);
      Integer mI = mMap.get(c);
      nI = (nI == null ? 0 : nI);
      mI = (mI == null ? 0 : mI);
      if (nI > mI) {
        return false;
      }
    }
    return true;
  }
}
