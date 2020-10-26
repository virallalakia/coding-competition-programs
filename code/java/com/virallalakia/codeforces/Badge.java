/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a solution for Badge problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * This causes Wrong Answer!
 *
 * @author Viral Lalakia 
 */
public class Badge {

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
      SYS_IN.nextLine();
      int[] nums = new int[n + 1];
      for (int ni = 1; ni <= n; ni++) {
        nums[ni] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      boolean[] visiting = new boolean[n];
      boolean[] visited = new boolean[n];
      int[] ans = new int[n + 1];
      int tmpi;
      for (int ni = 1; ni <= n; ni++) {
        tmpi = ni;
        while (ans[tmpi] == 0) {
          ans[tmpi] = -1;
          tmpi = nums[tmpi];
        }
        ans[ni] = tmpi;
        tmpi = ni;
        while (ans[ni] != tmpi) {
          if (ans[tmpi] <= 0) {
            ans[tmpi] = ans[ni];
          }
          tmpi = nums[tmpi];
        }
        while (ans[tmpi] < 0) {
          ans[tmpi] = nums[tmpi];
          tmpi = nums[tmpi];
        }
        System.out.print(ans[ni] + " ");
      }
      System.out.println();
    } catch (Exception e) {}
  }
}
