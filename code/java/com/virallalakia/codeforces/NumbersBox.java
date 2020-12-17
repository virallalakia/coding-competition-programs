/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is a solution for Numbers Box problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class NumbersBox {

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
      int m = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int mn = Integer.MAX_VALUE;
      long sum = 0L;
      int num;
      int sign = 1;
      for (int ni = 0; ni < n; ni++) {
        for (int mi = 0; mi < m; mi++) {
          num = SYS_IN.nextInt();
          if (num < 0) {
            sign *= -1;
            num = -num;
          }
          sum += num;
          mn = Math.min(mn, num);
        }
        SYS_IN.nextLine();
      }
      if (sign == -1) {
        sum -= 2 * mn;
      }
      System.out.println(sum);
    } catch (Exception e) {}
  }
}
