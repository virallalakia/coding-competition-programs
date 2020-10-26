/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start. This is verified on Google Kick Start site.
 * Package definition needs to be removed and class name needs to be changed to 'Solution' before submission.
 * Competition: Google Kick Start 2020 - Round B
 * Problem: Problem A (Bike Tour)
 */
public class BikeTour {

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
      int n = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int cur, prev1, prev2;
      int ans = 0;
      n -= 2;
      prev2 = SYS_IN.nextInt();
      prev1 = SYS_IN.nextInt();
      for (int ni = 0; ni < n; ni++) {
          cur = SYS_IN.nextInt();
          if (prev1 > prev2 && prev1 > cur) {
            ans++;
          }
          prev2 = prev1;
          prev1 = cur;
      }
      SYS_IN.nextLine();

      System.out.println("Case #" + t + ": " + ans);
    } catch (Exception e) {
    }
  }
}
