/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rf.problemB_MetalHarvest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: F
 * Problem: Problem B (Metal Harvest)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int t = SYS_IN.nextInt();
    for (int ti = 0; ti < t; ti++) {
      evaluateCase(ti + 1);
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t) {
    try {
      int n = SYS_IN.nextInt();
      double k = SYS_IN.nextInt();
      SYS_IN.nextLine();
      Queue<Integer> queue = new PriorityQueue<>(n << 1);
      for (int ni = 0; ni < n; ni++) {
        queue.offer(SYS_IN.nextInt());
        queue.offer(SYS_IN.nextInt());
        SYS_IN.nextLine();
      }

      int ans = 0;
      int prev = 0;
      int s;
      int e;
      while (!queue.isEmpty()) {
        s = Math.max(prev, queue.poll());
        e = queue.poll();
        e = (int) Math.ceil((e - s) / k);
        prev = (int) (s + (k * e));
        ans += e;
      }
      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
