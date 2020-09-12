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
 * This is a solution for ClosestToTheLeft(BinarySearch) problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ClosestToTheLeft_BinarySearch {

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
        System.out.println(binarySearch(nums, SYS_IN.nextInt()));
      }
      SYS_IN.nextLine();
    } catch (Exception e) {}
  }

  /**
   * BinarySearch algorithm for non-decreasing nums.
   * Returns the maximum index (starting from 1) of an array element not greater
   * than the given one. If there are none, returns 0.
   * 
   * @param nums array of non-decreasing numbers (ints)
   * @param k number to binarySearch in nums array
   * 
   * @return Maximum index (starting from 1) of an array element not greater
   * than k, 0 otherwise
   */
  private static int binarySearch(int[] nums, int k) {
    if (nums == null) {
      return 0;
    }

    // invariants: nums[lo] <= k and nums[hi] > k
    // so li will be the 0 based index for answer
    int lo = -1;
    int hi = nums.length;
    int m;
    while (lo + 1 < hi) {
      m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
      if (nums[m] <= k) {
        lo = m;
      } else {
        hi = m;
      }
    }
    return lo + 1; // return 1 based index as answer
  }
}
