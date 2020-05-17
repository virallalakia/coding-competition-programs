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
 * Problem: Problem C (People Whose List of Favorite Companies Is Not a Subset of Another List)
 * Result: Wrong Answer
 * Year: 2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionC_People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List {
  public List<Integer> peopleIndexes(List<List<String>> ip) {
    List<Integer> R = new ArrayList<>();
    if (ip == null || ip.isEmpty()) {
      return R;
    }

    List<Custom> ip2 = new ArrayList<>(ip.size());
    for (int i = 0; i < ip.size(); i++) {
      ip2.add(new Custom(i, ip.get(i)));
    }
    ip2.sort((e1, e2) -> e2.l.size() - e1.l.size());
    Set<Custom> ip3 = new HashSet<>(ip2);
    R = ip3.stream().map(e -> e.i).collect(Collectors.toList());
    Collections.sort(R);
    return R;
  }

  class Custom implements Comparable<Custom> {
    int i;
    List<String> l;

    public Custom(final int i, final List<String> l) {
      this.i = i;
      this.l = (l == null) ? new ArrayList<>(0) : l;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Custom custom = (Custom) o;

      return l.containsAll(custom.l) || custom.l.containsAll(l);

    }

    @Override
    public int compareTo(final Custom o) {
      return this.i - o.i;
    }
  }
}
