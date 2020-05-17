/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2020.r1c.problemB_Overrandomized;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1c
 * Problem: Problem B (Overrandomized)
 * Result: Incomplete
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _U_) {
    SYS_IN.nextLine();
    char[] ans = new char[10];
    boolean[] flags = new boolean[10];
    Map<Character, Boolean> chars = new HashMap<>(10);
    Map<Long, List<Query>> fullItems = new HashMap<>();
    try {
      Query q;
      List<Query> queries;
      for (short i = 0; i < 10000; i++) {
        q = new Query(SYS_IN.nextLong(), SYS_IN.nextLine().trim());
        queries = fullItems.computeIfAbsent(q.query, k -> new ArrayList<>());
        queries.add(q);
        chars.put(q.response.charAt(0), false);
        if (chars.size() < 10) {
          for (char c : q.response.toCharArray()) {
            chars.putIfAbsent(c, true);
          }
        }
      }
      short ti = 0;
      for (char c : chars.keySet()) {
        ans[ti++] = c;
      }
      List<Map.Entry<Character, Boolean>> collect =
          chars.entrySet().stream().filter(e -> e.getValue()).collect(Collectors.toList());
      if (collect.size() == 1) {
        findAndSwap(ans, collect.get(0).getKey(), 0);
        flags[0] = true;
      }
      collect = null;

      for (short i = 1; i < 10; i++) {
        findX(fullItems, i, chars, ans, flags, _U_);
      }
    } catch (Exception e) {
    }
    return (String.format("Case #%d: %s", t, new String(ans)));
  }

  private static void findX(Map<Long, List<Query>> fullItems, int i, Map<Character, Boolean> chars, final char[] ans,
      final boolean[] flags, final int _U_) {
    List<Query> queries = fullItems.get(i);
    if (queries != null && !queries.isEmpty()) {
      for (Query tq : queries) {
        char tc = tq.response.charAt(0);
        if (chars.get(tc)) {
          continue;
        }
        findAndSwap(ans, tc, i);
        flags[i] = true;
        chars.put(tc, true);
      }
    }
    int u = 2;
    while (!flags[i] && u <= _U_) {
      long pow = (long) Math.pow(10, u - 1);
      queries = getList(fullItems, pow * i, pow * i + pow);
      if (queries != null && !queries.isEmpty()) {
        for (Query tq : queries) {
          if (tq.response.length() == u) {
            char tc = tq.response.charAt(0);
            if (chars.get(tc)) {
              continue;
            }
            findAndSwap(ans, tc, i);
            flags[i] = true;
            chars.put(tc, true);
          }
        }
      }
      u++;
    }

  }

  private static void findAndSwap(final char[] ans, final char tc, final int index) {
    for (short i = 0; i < ans.length; i++) {
      if (ans[i] == tc) {
        ans[i] = ans[index];
        ans[index] = tc;
        break;
      }
    }
  }

  private static List<Query> getList(Map<Long, List<Query>> fullItems, long a, long b) {
    List<Query> r = new ArrayList<>();
    for (long i = a; i < b; i++) {
      List<Query> queries = fullItems.get(i);
      if (queries != null) {
        r.addAll(queries);
      }
    }
    return r;
  }

  static class Query {
    long query;
    String response;

    public Query(final long query, final String response) {
      this.query = query;
      this.response = response;
    }

    @Override
    public String toString() {
      final StringBuffer sb = new StringBuffer("Query{");
      sb.append("query=").append(query);
      sb.append(", response='").append(response).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }

}
