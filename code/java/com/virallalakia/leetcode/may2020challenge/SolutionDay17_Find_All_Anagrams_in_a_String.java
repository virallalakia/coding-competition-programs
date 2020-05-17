/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.may2020challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 17 (Find All Anagrams in a String)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay17_Find_All_Anagrams_in_a_String {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> R = new ArrayList<>();
    if (s == null || p == null || (s = s.trim()).isBlank() || (p = p.trim()).isBlank() || s.length() < p.length()) {
      return R;
    }
    int[] pCount = new int[26];
    for (char ch : p.toCharArray()) {
      pCount[ch - 'a']++;
    }
    int[] sCount = new int[26];
    for (int i = 0; i < p.length(); i++) {
      sCount[s.charAt(i) - 'a']++;
    }
    if (Arrays.equals(sCount, pCount)) {
      R.add(0);
    }
    for (int i = 1; i <= s.length() - p.length(); i++) {
      sCount[s.charAt(i - 1) - 'a']--;
      sCount[s.charAt(i + p.length() - 1) - 'a']++;
      if (Arrays.equals(sCount, pCount)) {
        R.add(i);
      }
    }
    return R;
  }
}
