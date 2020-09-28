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
 * This is a solution for Symmetric Matrix problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class SymmetricMatrix {

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
      int m = SYS_IN.nextInt();
      boolean ans = false;
      for (int ni = 0; ni < n; ni++) {
        int c12, c21;
        SYS_IN.nextInt();
        c12 = SYS_IN.nextInt();
        SYS_IN.nextLine();
        c21 = SYS_IN.nextInt();
        SYS_IN.nextInt();
        SYS_IN.nextLine();
        if (!ans && c12 == c21) {
          ans = true;
        }
      }

      System.out.println((ans && ((m & 1) == 0)) ? "YES" : "NO");
    } catch (Exception e) {}
  }
}
