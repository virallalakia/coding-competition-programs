/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Container With Most Water problem of Leetcode.
 * This is verified on https://leetcode.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
class Solution {
  public int maxArea(int[] height) {
    int ans = -1;
    for (int lt = 0, rt = height.length - 1; lt < rt; ) {
      ans = Math.max(ans, (rt - lt) * Math.min(height[lt], height[rt]));
      if (height[lt] < height[rt]) {
        lt++;
      } else if (height[lt] > height[rt]) {
        rt--;
      } else {
        if (height[lt + 1] < height[rt - 1]) {
          rt--;
        } else {
          lt++;
        }
      }
    }
    return ans;
  }
}
