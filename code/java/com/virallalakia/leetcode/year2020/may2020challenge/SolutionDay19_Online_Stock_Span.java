/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.leetcode.year2020.may2020challenge;

/*
 * This is a solution for one of the problems for LeetCode May Challenge 2020.
 * Competition: LeetCode May Challenge 2020
 * Problem: Problem 19 (Online Stock Span)
 * Result: Pass
 * Year: 2020
 */
public class SolutionDay19_Online_Stock_Span {
}

class StockSpanner {

  short[] p;
  short[] c;
  short cur;

  public StockSpanner() {
    p = new short[10000];
    c = new short[10000];
    cur = 0;
  }

  public int next(int price) {
    p[cur] = (short)price;
    int R = 1;
    for (short tcur = (short)(cur - 1); tcur >=0 && p[tcur] <= p[cur]; tcur-=c[tcur]) {
      R+=c[tcur];
    }
    c[cur] = (short)R;
    cur++;
    return R;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
