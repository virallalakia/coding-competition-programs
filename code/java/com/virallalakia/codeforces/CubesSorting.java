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
 * This is a solution for Cubes Sorting problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 *
 * @author Viral Lalakia
 */
public class CubesSorting {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
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
      int prev = SYS_IN.nextInt();
      int cur;
      boolean ans = false;
      for (int ni = 1; ni < n; ni++) {
        cur = SYS_IN.nextInt();
        if (prev <= cur) {
          ans = true;
        }
        prev = cur;
      }
      SYS_IN.nextLine();

      System.out.println(ans ? "YES" : "NO");
    } catch (Exception e) {
    }
  }
}
