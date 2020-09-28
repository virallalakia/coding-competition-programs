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
 * This is a solution for Non-zero Segments problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission. (TLE)
 * 
 * @author Viral Lalakia 
 */
public class NonZeroSegments {

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
      int[] nums = new int[n];
      nums[0] = SYS_IN.nextInt();
      int mx = nums[0];
      int mn = nums[0];
      int prev = 0;
      int ans = 0;
      for (int ni = 1; ni < n; ni++) {
        nums[ni] = SYS_IN.nextInt();
        if (nums[ni] + mx == 0 || nums[ni] + mn == 0) {
          ans++;
          mx = nums[ni];
          mn = nums[ni];
          prev = ni;
        } else {
          mx = Math.max(nums[ni], mx + nums[ni]);
          mn = Math.min(nums[ni], mn + nums[ni]);
          if (mx > 0 && mn < 0) {
            int t = 0;
            for (int ti = ni; ti >= prev; ti--) {
              t += nums[ti];
              if (t == 0) {
                ans++;
                mx = nums[ni];
                mn = nums[ni];
                prev = ni;
                break;
              }
            }
          }
        }
      }
      SYS_IN.nextLine();

      System.out.println(ans);
    } catch (Exception e) {}
  }
}
