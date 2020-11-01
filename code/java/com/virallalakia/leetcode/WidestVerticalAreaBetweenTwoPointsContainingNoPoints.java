/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

import java.util.*;

/**
 * This is a solution for Widest Vertical Area Between Two Points Containing No Points problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 *
 * @author Viral Lalakia
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
  // ======== submission start ========
  public int maxWidthOfVerticalArea(int[][] points) {
    int ans = 0;
    Arrays.sort(points, Comparator.comparingInt(e -> e[0]));
    for (int i = 1; i < points.length; i++) {
      ans = Math.max(ans, points[i][0] - points[i - 1][0]);
    }
    return ans;
  }
  // ======== submission end ========
}
