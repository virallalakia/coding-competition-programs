/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.qual.problemC_ReversortEngineering;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: Qualification
 * Problem: Problem C (Reversort Engineering)
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
    try {
      int _N_ = SYS_IN.nextInt();
      int _C_ = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int maxCost = ((_N_ * (_N_ + 1)) / 2) - 1;
      if (_C_ < _N_ - 1 || _C_ > maxCost) {
        return String.format("Case #%d: IMPOSSIBLE", t);
      }
      int[] nums = new int[_N_];
      int[] costs = new int[_N_];
      _C_ -= _N_ - 1;
      maxCost = _N_ - 1;
      for (int i = 0; i < _N_ - 1; i++) {
        nums[i] = i + 1;
        costs[i] = Math.max(0, Math.min(_C_, maxCost));
        _C_ -= costs[i];
        maxCost--;
      }
      nums[_N_ - 1] = _N_;
      for (int i = _N_ - 2; i >= 0; i--) {
        if (costs[i] > 0) {
          reverse(nums, i, i + costs[i]);
        }
      }
      StringBuilder sb = new StringBuilder();
      sb.append("Case #").append(t).append(":");
      for (int i = 0; i < _N_; i++) {
        sb.append(" ").append(nums[i]);
      }
      return sb.toString();
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: IMPOSSIBLE", t);
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
