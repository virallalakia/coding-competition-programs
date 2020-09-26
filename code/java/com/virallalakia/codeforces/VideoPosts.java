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
 * This is a solution for Video Posts problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class VideoPosts {

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
      int k = SYS_IN.nextInt();
      int[] nums = new int[n];
      int total = 0;
      for (int ni = 0; ni < n; ni++) {
        nums[ni] = SYS_IN.nextInt();
        total += nums[ni];
      }
      SYS_IN.nextLine();

      boolean ans = true;
      if (total % k != 0) {
        ans = false;
      }
      if (ans) {
        int tmp = 0;
        int ki = 0;
        int mx = total / k;
        for (int ni = 0; ni < n; ni++) {
          tmp += nums[ni];
          if (tmp == mx) {
            nums[ki] = ni + 1;
            ki++;
            tmp = 0;
          } else if (tmp > mx || ni == n - 1) {
            ans = false;
            break;
          }
        }
      }
      System.out.println(ans ? "Yes" : "No");
      if (ans) {
        System.out.print(nums[0]);
        for (int ki = 1; ki < k; ki++) {
          System.out.printf(" %d", nums[ki] - nums[ki - 1]);
        }
        System.out.println("");
      }
    } catch (Exception e) {}
  }
}
