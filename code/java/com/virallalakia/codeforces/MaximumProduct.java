/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a solution for Maximum Product problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class MaximumProduct {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase();
    }
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      final int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      final long[] mx = new long[6];
      final long[] mn = new long[6];
      Arrays.fill(mx, -(1L << 60));
      Arrays.fill(mn, 1L << 60);
      mx[0] = mn[0] = 1L;
      int t;
      for (int ni = 0; ni < n; ni++) {
        t = SYS_IN.nextInt();
        for (int mi = Math.min(ni, 4); mi >= 0; mi--) {
          mx[mi + 1] = Math.max(mx[mi + 1], Math.max(mx[mi] * t, mn[mi] * t));
          mn[mi + 1] = Math.min(mn[mi + 1], Math.min(mn[mi] * t, mx[mi] * t));
        }
      }
      SYS_IN.nextLine();
      System.out.println(mx[5]);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
