/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a solution for Add Candies problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class Knapsack {

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
      long n = SYS_IN.nextLong();
      long w = SYS_IN.nextLong();
      SYS_IN.nextLine();
      long halfW = (w + 1) >> 1;
      long num;
      long sum = 0L;
      List<Integer> ans = new ArrayList<>((int) n);
      for (int ni = 1; ni <= n; ni++) {
        num = SYS_IN.nextLong();
        if (num <= w) {
          if (num >= halfW) {
            ans.clear();
            ans.add(ni);
            sum = num;
            break;
          } else {
            sum += num;
            ans.add(ni);
            if (sum >= halfW) {
              break;
            }
          }
        }
      }
      SYS_IN.nextLine();

      if (!ans.isEmpty() && sum >= halfW && sum <= w) {
        System.out.println(ans.size());
        for (Integer i : ans) {
          System.out.print(i + " ");
        }
        System.out.println();
      } else {
        System.out.println(-1);
      }
    } catch (Exception e) {}
  }
}
