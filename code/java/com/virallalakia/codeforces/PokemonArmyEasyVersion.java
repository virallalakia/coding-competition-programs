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
 * This is a solution for Pokémon Army (easy version) problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class PokemonArmyEasyVersion {

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
      SYS_IN.nextInt(); // q is always 0
      SYS_IN.nextLine();
      int prev = SYS_IN.nextInt();
      int cur;
      n--;
      long ans = 0;
      int mn;
      if (n == 0) {
        ans = prev;
      } else {
        cur = SYS_IN.nextInt();
        n--;
        while (n > 0 && prev <= cur) {
          prev = cur;
          cur = SYS_IN.nextInt();
          n--;
        }
        ans = Math.max(prev, cur);
        prev = cur;
        while (n > 0) {
          while (n > 0 && prev >= cur) {
            prev = cur;
            cur = SYS_IN.nextInt();
            n--;
          }
          mn = Math.min(prev, cur);
          prev = cur;
          while (n > 0 && prev <= cur) {
            prev = cur;
            cur = SYS_IN.nextInt();
            n--;
          }
          ans += Math.max(0, Math.max(prev, cur) - mn);
        }
      }
      SYS_IN.nextLine();
      System.out.println(ans);
    } catch (Exception e) {}
  }
}
