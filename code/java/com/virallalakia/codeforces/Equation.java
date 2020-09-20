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
 * This is a solution for Equation problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class Equation {

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
      double c = SYS_IN.nextDouble();
      SYS_IN.nextLine();

      // f(lo) is always false
      // f(hi) is always true
      double lo = 0.0;
      double hi = 10e5 + 1;
      double m;
      for (int i = 0; 10e-8 < hi - lo && i < 100; i++) {
        m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
        if (predicate(m, c)) {
          hi = m;
        } else {
          lo = m;
        }
      }
      System.out.println(hi);
    } catch (Exception e) {}
  }

  private static boolean predicate(double m, double c) {
    return (m * m + Math.sqrt(m)) < c;
  }
}
