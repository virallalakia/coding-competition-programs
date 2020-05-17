/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2020.r1a.problemA_PatternMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1a
 * Problem: Problem A (Pattern Matching)
 * Result: Set 1 (Pass)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String WC = "*";
  private static final String WC_REGEX = "\\*";

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _N_) {
    SYS_IN.nextLine();
    boolean startsWithWC = true;
    boolean onlyOneWC = true;
    try {
      List<String> patterns = new ArrayList<>(_N_);
      for (int i = 0; i < _N_; i++) {
        patterns.add(SYS_IN.nextLine());
        if (!patterns.get(i).startsWith(WC)) {
          startsWithWC = false;
        }
        if (patterns.get(i).replace(WC, "").length() != patterns.get(i).length() - 1) {
          onlyOneWC = false;
        }
      }
      if (onlyOneWC) {
        if (startsWithWC) {
          String longestPattern = "";
          int maxLength = -1;
          for (int i = 0; i < _N_; i++) {
            String s = patterns.get(i).substring(1);
            patterns.set(i, s);
            if (s.length() > maxLength) {
              maxLength = s.length();
              longestPattern = s;
            }
          }
          for (int i = 0; i < _N_; i++) {
            if (!longestPattern.endsWith(patterns.get(i))) {
              return String.format("Case #%d: %s", t, WC);
            }
          }
          return String.format("Case #%d: %s", t, longestPattern);
        } else {
          int maxLength = -1;
          for (int i = 0; i < _N_; i++) {
            String s = patterns.get(i);
            if (s.length() > maxLength) {
              maxLength = s.length();
            }
          }
          List<String> longestPatterns = new ArrayList<>();
          for (int i = 0; i < _N_; i++) {
            if (maxLength == patterns.get(i).length()) {
              longestPatterns.add(patterns.get(i));
            }
          }
          char[] ans = new char[maxLength];
          for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < longestPatterns.size(); j++) {
              char ch = longestPatterns.get(j).charAt(i);
              if (ch != '*') {
                ans[i] = ch;
                break;
              }
            }
          }
          String ansStr = new String(ans);
          ansStr = ansStr.replace(WC, "");
          for (int i = 0; i < _N_; i++) {
            if (patterns.get(i).startsWith(WC)) {
              if (!ansStr.endsWith(patterns.get(i).substring(1))) {
                return String.format("Case #%d: %s", t, WC);
              }
            } else if (patterns.get(i).endsWith(WC)) {
              if (!ansStr.startsWith(patterns.get(i).substring(0, patterns.get(i).length() - 1))) {
                return String.format("Case #%d: %s", t, WC);
              }
            } else {
              String[] parts = patterns.get(i).split(WC_REGEX);
              if (!ansStr.startsWith(parts[0]) || !ansStr.endsWith(parts[1])) {
                return String.format("Case #%d: %s", t, WC);
              }
            }
          }
          return String.format("Case #%d: %s", t, ansStr);
        }
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, WC);
  }

}
