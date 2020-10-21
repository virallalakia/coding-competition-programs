/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rg.problemB_MaximumCoins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: G
 * Problem: Problem B (Maximum Coins)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int t = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase(ti + 1);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t) {
    try {
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      long[] paths = new long[2 * n - 1];
      long ans = 0L;
      int tmp;
      n--;
      for (int ri = 0; ri <= n; ri++) {
        for (int ci = 0; ci <= n; ci++) {
          tmp = SYS_IN.nextInt();
          paths[n + ri - ci] += tmp;
          if (ri == n || ci == n) {
            ans = Math.max(ans, paths[n + ri - ci]);
          }
        }
        SYS_IN.nextLine();
      }

      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
