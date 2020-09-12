/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.re.problemA_Longestrithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: E
 * Problem: Problem A (Longest Arithmetic)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    try {
      int _N_ = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] ip = new int[_N_];
      for (int i = 0; i < _N_; i++) {
        ip[i] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      int ans = 2;
      if (_N_ <= 2) {
        ans = _N_;
      } else {
        int lastdiff = ip[1] - ip[0];
        int curMax = ans;
        for (int i = 2; i < _N_; i++) {
          if (lastdiff == ip[i] - ip[i - 1]) {
            curMax++;
          } else {
            ans = Math.max(ans, curMax);
            lastdiff = ip[i] - ip[i - 1];
            curMax = 2;
          }
        }
        ans = Math.max(ans, curMax);
      }
      return String.format("Case #%d: %d", t, ans);
    } catch (Exception e) {
    }
    return String.format("Case #%d: %d", t, 0);
  }
}
