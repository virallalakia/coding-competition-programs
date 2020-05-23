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
 * Problem: Problem 22 (Sort Characters By Frequency)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay22_Sort_Characters_By_Frequency {
  public String frequencySort(String s) {
    Map<Character, CharCount> countMap = new HashMap<>();
    IntStream.range(0, s.length())
      .forEach(i -> countMap.computeIfAbsent(s.charAt(i), k -> new CharCount(k, 0)).c++);
    List<CharCount> list = new ArrayList<>(countMap.values());
    list.sort((a,b) -> b.c - a.c);
    StringBuilder sb = new StringBuilder();
    list.stream()
      .map(e -> String.join("", Collections.nCopies(e.c, e.ch+"")))
      .forEachOrdered(e -> sb.append(e));
    return sb.toString();
  }
}

class CharCount {
  char ch;
  int c;

  CharCount (char ch, int c) {
    this.ch = ch;
    this.c = c;
  }
}
