/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.year2020.weeklycontest189;

/*
 * This is a solution for one of the problems for LeetCode Weekly-Contest-189 (May 2020).
 * Competition: LeetCode Weekly-Contest-189 (May 2020)
 * Problem: Problem B (Rearrange Words in a Sentence)
 * Result: Pass
 * Year: 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionB_Rearrange_Words_in_a_Sentence {
  public String arrangeWords(String ip) {
    if (ip == null || (ip = ip.trim()).isBlank()) {
      return ip;
    }
    List<String> list = new ArrayList<>(Arrays.asList(ip.toLowerCase().split(" ")));
    list.sort(Comparator.comparingInt(String::length));
    ip = String.join(" ", list);
    return ip.substring(0, 1).toUpperCase() + ip.substring(1);
  }
}
