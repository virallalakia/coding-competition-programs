/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a solution for Array Rearrangment problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ArrayRearrangment {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
    for (int ti = 0; ti < t; ti++) {
      SYS_IN.nextLine(); // handle with care
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
      int x = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int ai = 0; ai < n; ai++) {
        a[ai] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();
      for (int bi = 0; bi < n; bi++) {
        b[bi] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();
      Arrays.sort(a);
      Arrays.sort(b);
      boolean ans = true;
      n--;
      for (int i = 0; i <= n; i++) {
        if (a[i] + b[n - i] > x) {
          ans = false;
          break;
        }
      }
      System.out.println(ans ? "Yes" : "No");
    } catch (Exception e) {}
  }
}
