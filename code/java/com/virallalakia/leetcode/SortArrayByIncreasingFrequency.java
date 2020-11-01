/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This is a solution for Sort Array by Increasing Frequency problem of Leetcode.
 * This is verified on https://leetcode.com. Only marked code should be submitted.
 *
 * @author Viral Lalakia
 */
public class SortArrayByIncreasingFrequency {
  // ======== submission start ========
  public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> feqMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      feqMap.put(nums[i], feqMap.getOrDefault(nums[i], 0) + 1);
    }
    Queue<int[]> priQueue = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]));
    for (int i : feqMap.keySet()) {
      priQueue.offer(new int[] {i, feqMap.get(i)});
    }
    int i = 0;
    int[] elem;
    while (!priQueue.isEmpty()) {
      elem = priQueue.poll();
      while (elem[1] > 0) {
        elem[1]--;
        nums[i++] = elem[0];
      }
    }
    return nums;
  }
  // ======== submission end ========
}
