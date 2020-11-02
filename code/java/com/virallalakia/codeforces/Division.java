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
 * This is a solution for Division problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * The result is TLE.
 * 
 * @author Viral Lalakia 
 */
public class Division {

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
      long p = SYS_IN.nextLong();
      long q = SYS_IN.nextLong();
      SYS_IN.nextLine();
      if (p % q != 0) {
        System.out.println(p);
      } else {
        long ans = 1L;
        long pSqrt = (long) Math.sqrt(p);
        long tmp;
        for (long i = 2; i <= pSqrt; i++) {
          if (p % i == 0) {
            tmp = p / i;
            if (tmp % q != 0) {
              ans = tmp;
              break;
            } else if (i % q != 0) {
              ans = Math.max(ans, i);
            }
          }
        }
        System.out.println(ans);
      }
    } catch (Exception e) {}
  }
}
