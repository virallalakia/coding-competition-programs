/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start. This is verified on Google Kick Start site.
 * Package definition needs to be removed and class name needs to be changed to 'Solution' before submission.
 * Competition: Google Kick Start 2020 - Round H
 * Problem: Problem A (Retype)
 */
public class Retype {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int t = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase(ti + 1);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t) {
    try {
      long n = SYS_IN.nextLong();
      long k = SYS_IN.nextLong();
      long s = SYS_IN.nextLong();
      SYS_IN.nextLine();

      System.out.println("Case #" + t + ": " + (k + n + Math.min(0, k - s - s)));
    } catch (Exception e) {
    }
  }
}
