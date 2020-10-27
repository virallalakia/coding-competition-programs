/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2020 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.leetcode;

/**
 * This is a solution for Coin Change problem of Leetcode.
 * This is verified on https://leetcode.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
class Solution {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    Arrays.sort(coins);
    int numCoins = coins.length;
    for (int i = numCoins - 1; i >= 0; i--) {
      if (coins[i] == amount) {
        return 1;
      } else if (coins[i] > amount) {
        numCoins = i + 1;
      } else {
        break;
      }
    }
    int[] reqCoins = new int[amount + 1];
    int count;
    for (int ai = 1; ai <= amount; ai++) {
      count = Integer.MAX_VALUE;
      for (int ci = 0; ci < numCoins; ci++) {
        if (ai >= coins[ci] && reqCoins[ai - coins[ci]] != -1) {
          count = Math.min(count, reqCoins[ai - coins[ci]]);
        }
      }
      if (count == Integer.MAX_VALUE) {
        reqCoins[ai] = -1;
      } else {
        reqCoins[ai] = count + 1;
      }
    }
    return reqCoins[amount];
  }
}
