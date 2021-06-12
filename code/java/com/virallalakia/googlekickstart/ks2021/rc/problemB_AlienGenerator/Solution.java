/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2021.rc.problemB_AlienGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2021.
 * Competition: Google Kick Start 2021
 * Round: C
 * Problem: Problem B (Alien Generator)
 * Year: 2021
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
      long _G_ = SYS_IN.nextLong();
      SYS_IN.nextLine();
      int ans = 0;
      int i = 1;
      while (_G_ > 0) {
        if (_G_ % i == 0) {
          ans++;
        }
        _G_ -= i;
        i++;
      }

      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
