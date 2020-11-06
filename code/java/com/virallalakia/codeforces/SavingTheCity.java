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
 * This is a solution for Saving the City problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class SavingTheCity {

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
      int a = SYS_IN.nextInt();
      int b = SYS_IN.nextInt();
      SYS_IN.nextLine();
      char[] mines = SYS_IN.nextLine().toCharArray();
      int cost = (mines[0] == '1' ? a : 0);
      int zeroCount = 0;
      for (int i = 1; i < mines.length; i++) {
        if (mines[i] == '1') {
          if (zeroCount > 0 && cost > 0) {
            cost += Math.min(b * zeroCount, a);
          } else if (mines[i - 1] == '0') {
            cost += a;
          }
          zeroCount = 0;
        } else {
          zeroCount++;
        }
      }
      System.out.println(cost);
    } catch (Exception e) {}
  }
}
