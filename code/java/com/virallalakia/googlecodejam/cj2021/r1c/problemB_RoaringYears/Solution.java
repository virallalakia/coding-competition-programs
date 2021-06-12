/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.r1c.problemB_RoaringYears;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: 1C
 * Problem: Problem B (Roaring Years)
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final Map<Integer, List<String>> UNEVEN_SEGMENT_ROARING_YEARS =
      Map.ofEntries(
          Map.entry(3, List.of("910")),
          Map.entry(4, List.of("8910")),
          Map.entry(5, List.of("78910", "91011", "99100")),
          Map.entry(6, List.of("678910","891011")),
          Map.entry(7, List.of("5678910", "7891011", "9101112", "9899100", "9991000")),
          Map.entry(8, List.of("45678910", "67891011", "89101112", "99100101")),
          Map.entry(9, List.of("345678910", "567891011", "789101112", "910111213", "979899100", "999910000")),
          Map.entry(10, List.of("2345678910", "4567891011", "6789101112", "8910111213", "9899100101")),
          Map.entry(11, List.of()),
          Map.entry(12, List.of()),
          Map.entry(13, List.of()),
          Map.entry(14, List.of()),
          Map.entry(15, List.of()),
          Map.entry(16, List.of()),
          Map.entry(17, List.of()),
          Map.entry(18, List.of()),
          Map.entry(19, List.of()));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    long _A_ = SYS_IN.nextLong();
    SYS_IN.nextLine();
    try {
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: %d %d %d %d", t);
  }

}
