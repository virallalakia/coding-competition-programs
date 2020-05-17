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
 * Problem: Problem 5 (First Unique Character in a String)
 * Result: Pass
 * Year: 2020
 */

public class SolutionDay05_First_Unique_Character_in_a_String {
  public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    int[] arrC = new int[26];
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      switch (arrC[c-'a']) {
        case 0:
          arrC[c-'a'] = i+1;
          break;
        default:
          arrC[c-'a'] = -1;
      }
    }
    int R = -1;
    for (int i = 0; i < arrC.length; i++) {
      if (arrC[i] > 0) {
        if (R == -1) {
          R = arrC[i]-1;
        } else {
          R = Math.min(R, arrC[i]-1);
        }
      }
    }
    return R;
  }
}
