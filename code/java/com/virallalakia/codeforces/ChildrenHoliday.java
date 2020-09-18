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
 * This is a solution for Children Holiday problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ChildrenHoliday {

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
      int b = SYS_IN.nextInt();
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] t = new int[n];
      int[] z = new int[n];
      int[] y = new int[n];
      for (int ni = 0; ni < n; ni++) {
        t[ni] = SYS_IN.nextInt();
        z[ni] = SYS_IN.nextInt();
        y[ni] = SYS_IN.nextInt();
        SYS_IN.nextLine();
      }

      int[] temp = new int[n];
      // f(lo) is always false
      // f(hi) is always true
      int lo = 0;
      int hi = 1 << 31 - 1;
      int[] ans = temp;
      int m;
      while (lo + 1 < hi) {
        m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
        temp = new int[n];
        if (predicate(m, b, n, t, z, y, temp)) {
          hi = m;
          ans = temp;
        } else {
          lo = m;
        }
      }
      System.out.println(hi);
      for (int ni = 0; ni < n - 1; ni++) {
        System.out.print(String.format("%d ", ans[ni]));
      }
      System.out.println(ans[n - 1]);
    } catch (Exception e) {}
  }

  private static boolean predicate(int m, int b, int n, int[] t, int[] z, int[] y, int[] ans) {
    int count = 0;
    for (int ni = 0; ni < n; ni++) {
      int k = m + y[ni] / (t[ni] * z[ni] + y[ni]);
      ans[ni] = k * z[ni] + Math.max(0, (m - k * (t[ni] * z[ni] + y[ni])) / t[ni]);
      count += ans[ni];
    }
    return b <= count;
  }
}
