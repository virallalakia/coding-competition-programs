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
 * This is a solution for Toy Blocks problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ToyBlocks {

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
      long n = SYS_IN.nextLong();
      SYS_IN.nextLine();
      long sum = 0L;
      long mx = -1;
      long cur;
      for (int ni = 0; ni < n; ni++) {
        cur = SYS_IN.nextLong();
        mx = Math.max(mx, cur);
        sum += cur;
      }
      n--;
      System.out.println((Math.max((long) Math.ceil(((double) sum) / n), mx) * n) - sum);
    } catch (Exception e) {}
  }
}
