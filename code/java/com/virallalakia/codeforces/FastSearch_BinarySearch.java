/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a solution for FastSearch (BinarySearch) problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class FastSearch_BinarySearch {

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
      final int n = SYS_IN.nextInt(); // total numbers
      SYS_IN.nextLine();

      int[] nums = new int[n];
      for (int ni = 0; ni < n; ni++) {
        nums[ni] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();
      Arrays.sort(nums); // sort the array

      final int q = SYS_IN.nextInt(); // total queries
      SYS_IN.nextLine();

      for (int qi = 0; qi < q; qi++) {
        System.out.println(binarySearch(nums, SYS_IN.nextInt(), SYS_IN.nextInt()));
        SYS_IN.nextLine();
      }
    } catch (Exception e) {}
  }

  /**
   * Calculates count of numbers between given bounds.
   * Uses BinarySearch algorithm for non-decreasing nums.
   * 
   * @param nums array of non-decreasing numbers (ints)
   * @param l lower bound number, l <= all numbers in result count
   * @param r upper bound number, r >= all numbers in result count
   * 
   * @return Count of numbers between 2 given bounds l and r inclusive
   */
  private static int binarySearch(int[] nums, int l, int r) {
    if (nums == null) {
      return 0;
    }

    // invariants for lower bound l: nums[lo] < l and l <= nums[hi]
    // invariants for upper bound r: nums[lo] <= r and r < nums[hi]
    int lo = -1;
    int hi = nums.length;
    int m;
    while (lo + 1 < hi) {
      m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
      if (nums[m] < l) {
        lo = m;
      } else {
        hi = m;
      }
    }

    int hi1 = hi;

    // lo = lo; // any index <= lo always holds invariants true
    hi = nums.length;
    while (lo + 1 < hi) {
      m = lo + (hi - lo) / 2; // alternative way of using (lo + hi) / 2 might overflow
      if (nums[m] <= r) {
        lo = m;
      } else {
        hi = m;
      }
    }
    return (hi - hi1);
  }
}
