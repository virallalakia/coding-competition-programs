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
 * This is a solution for Two Brackets problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class TwoBrackets {

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
      char[] chars = SYS_IN.nextLine().toCharArray();
      int ans = 0;
      int smallCount = 0;
      int bigCount = 0;
      for (int ci = 0; ci < chars.length; ci++) {
        switch (chars[ci]) {
          case '(':
            smallCount++;
            break;
          case '[':
            bigCount++;
            break;
          case ')':
            if (smallCount > 0) {
              ans++;
              smallCount--;
            }
            break;
          case ']':
            if (bigCount > 0) {
              ans++;
              bigCount--;
            }
            break;
        }
      }
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
