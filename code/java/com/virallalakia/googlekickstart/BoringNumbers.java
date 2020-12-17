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
 * Problem: Problem B (Boring Numbers)
 */
public class BoringNumbers {

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
      long l = SYS_IN.nextLong();
      long r = SYS_IN.nextLong();
      SYS_IN.nextLine();

      long ans = 0;
      for (int i = Long.toString(l).length(); i < Long.toString(r).length(); i++) {
        ans += (long) Math.pow(5, i);
      }
      ans -= boringNumbersLessThanThis(l, false);
      ans += boringNumbersLessThanThis(r, true);

      System.out.println("Case #" + t + ": " + ans);
    } catch (Exception e) {
    }
  }

  private static int boringNumbersLessThanThis(final long n, final boolean includeThis) {
    char[] chars = Long.toString(n).toCharArray();
    int len = chars.length;
    long pow5 = (long) Math.pow(5, len - 1);
    int count = 0;
    boolean isThisValid = true;
    for (int i = 0; i < chars.length; i++) {
      count += ((chars[i] - '0' + (i % 2)) >> 1) * pow5;
      pow5 /= 5;
      if (i % 2 + (chars[i] - '0') % 2 != 1) {
        isThisValid = false;
        break;
      }
    }
    if (includeThis && isThisValid) {
      count++;
    }
    return count;
  }
}
