/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2021.rc.problemA_SmallerStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2021.
 * Competition: Google Kick Start 2021
 * Round: C
 * Problem: Problem A (Smaller Strings)
 * Year: 2021
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final int MOD_BY = 1_000_000_007;

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
      long _N_ = SYS_IN.nextLong(); // unused
      long _K_ = SYS_IN.nextLong();
      SYS_IN.nextLine();
      String inputStr = SYS_IN.nextLine();
      char[] chars = inputStr.toCharArray();
      int len = chars.length;
      int half = (len - 1) / 2;
      long ans = 0L;
      long multiplier = 1L;
      for (int i = half; i >= 0; i--) {
        ans = (ans + ((multiplier * (chars[i] - 'a')) % MOD_BY)) % MOD_BY;
        multiplier = (multiplier * _K_) % MOD_BY;
        chars[len - 1 - i] = chars[i];
      }
      if (new String(chars).compareTo(inputStr) < 0) {
        ans = (ans + 1) % MOD_BY;
      }

      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
