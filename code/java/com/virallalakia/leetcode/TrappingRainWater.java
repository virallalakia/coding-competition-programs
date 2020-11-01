/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Trapping Rain Water problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 * 
 * @author Viral Lalakia 
 */
public class TrappingRainWater {
  // ======== submission start ========
  public int trap(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }
    int n = height.length;
    int[] ltMax = new int[n];
    int[] rtMax = new int[n];
    ltMax[0] = rtMax[n - 1] = 0;
    for (int i = 1; i < n; i++) {
      ltMax[i] = Math.max(ltMax[i - 1], height[i - 1]);
      rtMax[n - 1 - i] = Math.max(rtMax[n - i], height[n - i]);
    }

    // answer should be long but expected answer is in int so I have taken it as int
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.max(0, Math.min(ltMax[i], rtMax[i]) - height[i]);
    }
    return ans;
  }
  // ======== submission end ========
}
