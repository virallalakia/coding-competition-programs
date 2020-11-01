/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Check Array Formation Through Concatenation problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 *
 * @author Viral Lalakia
 */
public class CheckArrayFormationThroughConcatenation {
  // ======== submission start ========
  public boolean canFormArray(int[] arr, int[][] pieces) {
    boolean[] flags = new boolean[arr.length];
    for (int i = 0; i < pieces.length; i++) {
      int k = 0;
      for (; k < arr.length; k++) {
        if (!flags[k] && arr[k] == pieces[i][0]) {
          break;
        }
      }
      if (k == arr.length) {
        return false;
      }
      flags[k] = true;
      for (int j = 1; j < pieces[i].length; j++) {
        if ((k + j) < arr.length && !flags[k + j] && arr[k + j] == pieces[i][j]) {
          flags[k + j] = true;
        } else {
          return false;
        }
      }
    }
    for (int i = 0; i < flags.length; i++) {
      if (!flags[i]) {
        return false;
      }
    }
    return true;
  }
  // ======== submission end ========
}
