/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.qual.problemA_Reversort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: Qualification
 * Problem: Problem A (Reversort)
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    int _N_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    int[] nums = new int[_N_];
    int cost = 0;
    int minIndex;
    try {
      for (int i = 0; i < _N_; i++) {
        nums[i] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      for (int i = 0; i < _N_ - 1; i++) {
        minIndex = i;
        for (int j = i + 1; j < _N_; j++) {
          minIndex = (nums[minIndex] < nums[j] ? minIndex : j);
        }
        cost += (minIndex - i + 1);
        reverse(nums, i, minIndex);
      }
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: %d", t, cost);
  }

  private static void reverse(final int[] arr, int i, int j) {
    int tempSwap;
    while (i < j) {
      tempSwap = arr[i];
      arr[i] = arr[j];
      arr[j] = tempSwap;
      i++;
      j--;
    }
  }
}
