/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is a solution for Ropes problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class Ropes {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    evaluateCase();
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      int k = SYS_IN.nextInt();
      SYS_IN.nextLine();

      int[] lens = new int[n];
      for (int ni = 0; ni < n; ni++) {
        lens[ni] = SYS_IN.nextInt();
        SYS_IN.nextLine();
      }

      // f(lo) is always false
      // f(hi) is always true
      double lo = 10e-5;
      double hi = 10e7 + 1;
      double m;
      for (int i = 0; 10e-8 < hi - lo && i < 100; i++) {
        m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
        if (predicate(m, n, k, lens)) {
          hi = m;
        } else {
          lo = m;
        }
      }
      System.out.println(hi);
    } catch (Exception e) {}
  }

  private static boolean predicate(double m, int n, int k, int[] lens) {
    long ans = 0;
    for (int ni = 0; ni < n; ni++) {
      ans += (long)Math.floor(lens[ni] / m);
    }
    return ans < k;
  }
}
