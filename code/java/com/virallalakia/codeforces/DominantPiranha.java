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
 * This is a solution for Dominant Piranha problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class DominantPiranha {

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
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int ans = -1;
      int prev2;
      int cur = SYS_IN.nextInt();
      int prev1 = cur;
      int mx = cur;
      for (int ni = 2; ni <= n; ni++) {
        prev2 = prev1;
        prev1 = cur;
        cur = SYS_IN.nextInt();
        mx = Math.max(mx, cur);
        if ((prev1 > cur && prev1 >= prev2) || (prev1 > prev2 && prev1 >= cur)) {
          if (prev1 >= mx) {
            ans = ni - 1;
          }
        }
      }
      if (prev1 < cur && cur >= mx) {
        ans = n;
      }
      SYS_IN.nextLine();
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
