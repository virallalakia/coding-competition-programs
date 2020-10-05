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
 * This is a solution for Metro problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class Metro {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    evaluateCase();
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      int s = SYS_IN.nextInt() - 1;
      SYS_IN.nextLine();
      boolean[] line1 = new boolean[n];
      boolean[] line2 = new boolean[n];
      boolean ans = false;
      for (int ni = 0; ni < n; ni++) {
        line1[ni] = (SYS_IN.nextInt() == 1);
      }
      SYS_IN.nextLine();
      for (int ni = 0; ni < n; ni++) {
        line2[ni] = (SYS_IN.nextInt() == 1);
        if (ni > s && !ans && line1[ni] && line2[ni]) {
          ans = true;
        }
      }
      SYS_IN.nextLine();

      ans = (line1[0] && (line1[s] || (line2[s] && ans)));

      System.out.println(ans ? "YES" : "NO");
    } catch (Exception e) {}
  }

}
