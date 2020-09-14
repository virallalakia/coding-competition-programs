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
 * This is a solution for Packing Rectangles problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class PackingRectangles {

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
      int w = SYS_IN.nextInt();
      int h = SYS_IN.nextInt();
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();

      // f(lo) is always false
      // f(hi) is always true
      long lo = (long)Math.max(w, h) - 1L;
      long hi = Math.max((long)Math.min(w, h) * (long)n, (long)Math.max(w, h));
      long m;
      while (lo + 1 < hi) {
        m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
        if (predicate(m, w, h, n)) {
          hi = m;
        } else {
          lo = m;
        }
      }
      System.out.println(hi);
    } catch (Exception e) {}
  }

  private static boolean predicate(long m, int w, int h, int n) {
    return (m / w) * (m / h) >= n;
  }
}
