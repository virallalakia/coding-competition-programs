/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This is a solution for Frequency Problem (Easy Version) problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class FrequencyProblemEasyVersion {

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
      SYS_IN.nextLine();
      int range = Math.min(n, 100);
      int[][] dp = new int[range][n + 1];
      int num;
      for (int ni = 1; ni <= n; ni++) {
        num = SYS_IN.nextInt() - 1;
        for (int ri = 0; ri < range; ri++) {
          dp[ri][ni] = dp[ri][ni - 1];
        }
        dp[num][ni]++;
      }
      SYS_IN.nextLine();

      int ans = 0;
      int mx1;
      int mx2;
      OUTER:
      for (int li = n; li > 1; li--) {
        for (int ri = 0; ri + li <= n; ri++) {
          mx1 = Integer.MIN_VALUE;
          mx2 = Integer.MIN_VALUE;
          for (int i = 0; i < range; i++) {
            mx2 = Math.max(mx2, dp[i][ri + li] - dp[i][ri]);
            if (mx2 > mx1) {
              num = mx1;
              mx1 = mx2;
              mx2 = num;
            }
          }
          if (mx1 == mx2) {
            ans = li;
            break OUTER;
          }
        }
      }

      System.out.println(ans);
    } catch (Exception e) {}
  }
}
