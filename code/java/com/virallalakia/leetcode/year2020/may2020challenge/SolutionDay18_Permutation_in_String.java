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
 * Problem: Problem 18 (Permutation in String)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay18_Permutation_in_String {
  public boolean checkInclusion(String p, String s) {
    if (s == null || p == null || (s = s.trim()).isBlank() || (p = p.trim()).isBlank() || s.length() < p.length()) {
      return false;
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
      return true;
    }
    for (int i = 1; i <= s.length() - p.length(); i++) {
      sCount[s.charAt(i-1) - 'a']--;
      sCount[s.charAt(i+p.length()-1) - 'a']++;
      if (Arrays.equals(sCount, pCount)) {
        return true;
      }
    }
    return false;
  }
}
