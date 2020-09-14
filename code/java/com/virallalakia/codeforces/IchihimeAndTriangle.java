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
 * This is a solution for Ichihime and Triangle problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class IchihimeAndTriangle {

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
      // inputs are a, b, c, d where a <= b <= c <= d
      // answer can always be x = b, y = c, z = c
      // where a <= x <= b <= y <= c <= z <= d with
      // x, y, z as length of sides of a triangle with area > 0
      SYS_IN.nextInt(); // skipping
      int b = SYS_IN.nextInt();
      int c = SYS_IN.nextInt();
      SYS_IN.nextInt(); // skipping
      SYS_IN.nextLine();

      System.out.println(String.format("%d %d %d", b, c, c));
    } catch (Exception e) {}
  }
}
