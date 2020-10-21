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
 * This is a solution for Yet Another Bookshelf problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class YetAnotherBookshelf {

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
      int first1 = 0;
      int last1 = 0;
      int count1 = 0;
      for (int ni = 1; ni <= n; ni++) {
        if (SYS_IN.nextInt() == 1) {
          if (first1 == 0) {
            first1 = ni;
          }
          last1 = ni;
          count1++;
        }
      }
      SYS_IN.nextLine();
      int ans = 0;
      if (count1 > 0) {
        ans = last1 - first1 - count1 + 1;
      }
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
