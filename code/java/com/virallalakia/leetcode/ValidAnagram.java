/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Valid Anagram problem of Leetcode.
 * This is verified on https://leetcode.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) {
      return s == t;
    }
    int len = s.length();
    if (len != t.length()) {
      return false;
    }
    int[] counters = new int[26];
    for (int i = 0; i < len; i++) {
      counters[s.charAt(i) - 'a']++;
      counters[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < counters.length; i++) {
      if (counters[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
