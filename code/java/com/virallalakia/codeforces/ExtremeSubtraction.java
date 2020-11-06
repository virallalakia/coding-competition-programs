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
 * This is a solution for Extreme Subtraction problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ExtremeSubtraction {

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
      int[] nums = new int[n + 1];
      int[] rMin = new int[n + 1];
      for (int ni = 1; ni <= n; ni++) {
        nums[ni] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();
      rMin[0] = 0;
      rMin[n] = nums[n];
      for (int ri = n - 1; ri > 0; ri--) {
        rMin[ri] = Math.min(nums[ri], rMin[ri + 1]);
      }
      boolean ans = true;
      int lMin = nums[1];
      for (int ni = 1; ni <= n; ni++) {
        lMin = Math.min(Math.min(nums[ni], lMin) , nums[ni] - rMin[ni - 1]);
        if (lMin + rMin[ni] < nums[ni]) {
          ans = false;
          break;
        }
        rMin[ni] = nums[ni] - lMin;
      }
      System.out.println(ans ? "YES" : "NO");
    } catch (Exception e) {}
  }
}
