/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.qual.problemB_MoonsAndUmbrellas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: Qualification
 * Problem: Problem B (Moons and Umbrellas)
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    int cost = 0;
    try {
      int _X_ = SYS_IN.nextInt();
      int _Y_ = SYS_IN.nextInt();
      char[] chars = SYS_IN.nextLine().toCharArray();
      int i = 0;
      while (i < chars.length && chars[i] == '?') {
        i++;
      }
      if (i != chars.length) {
        for (int j = i; j > 0; j--) {
          chars[j - 1] = chars[j];
        }
        while (i < chars.length) {
          if (chars[i] == '?') {
            chars[i] = chars[i - 1];
          }
          i++;
        }
        for (int j = 1; j < chars.length; j++) {
          if (chars[j - 1] == 'C' && chars[j] == 'J') {
            cost += _X_;
          } else if (chars[j - 1] == 'J' && chars[j] == 'C') {
            cost += _Y_;
          }
        }
      }
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: %d", t, cost);
  }
}
