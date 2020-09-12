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
 * This is a solution for BinarySearch problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class BinarySearch {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  /**
   * Main method for solution. Calls to evaluate one of more test cases.
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
      final int n = SYS_IN.nextInt(); // total numbers
      final int q = SYS_IN.nextInt(); // total queries
      SYS_IN.nextLine();

      int[] nums = new int[n];
      for (int ni = 0; ni < n; ni++) {
        nums[ni] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      for (int qi = 0; qi < q; qi++) {
        System.out.println(binarySearch(nums, SYS_IN.nextInt()) ? "YES" : "NO");
      }
      SYS_IN.nextLine();
    } catch (Exception e) {}
  }

  /**
   * BinarySearch algorithm for non-decreasing nums.
   * 
   * @param nums array of non-decreasing numbers (ints)
   * @param k number to binarySearch in nums array
   * 
   * @return true if k is present in nums, false otherwise
   */
  private static boolean binarySearch(int[] nums, int k) {
    if (nums == null) {
      return false;
    }

    int lo = 0;
    int hi = nums.length - 1;
    int m;
    while (lo <= hi) {
      m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
      if (nums[m] == k) {
        return true;
      } else if (nums[m] < k) {
        lo = m + 1;
      } else {
        hi = m - 1;
      }
    }
    return false;
  }
}
