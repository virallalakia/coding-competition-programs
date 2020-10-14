/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * This is a solution for Chess Cheater problem of Codeforces.
 * This is verified on https://codeforces.com. Package definition needs to be removed before submission.
 * 
 * @author Viral Lalakia 
 */
public class ChessCheater {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  static class Slot implements Comparable<Slot> {
    int sz;
    int type;

    public Slot(int sz, int type) {
      this.sz = sz;
      this.type = type;
    }

    @Override
    public int compareTo(Slot o) {
      if (o.type == this.type) {
        return this.sz - o.sz;
      }
      return o.type - this.type;
    }
  }

  /**
   * Main method for solution. Calls to evaluate one or more test cases.
   */
  public static void main(String[] args) {
    final int t = SYS_IN.nextInt(); // total test cases
    for (int ti = 0; ti < t; ti++) {
      evaluateCase();
    }
    SYS_IN.close();
  }

  /**
   * Evaluate a test case. Handles I/O.
   */
  private static void evaluateCase() {
    try {
      int n = SYS_IN.nextInt();
      int k = SYS_IN.nextInt();
      SYS_IN.nextLine();
      Queue<Slot> queue = new PriorityQueue<>(n);
      int winStreak = 0;
      int loseStreak = 0;
      int points = 0;
      String seq = SYS_IN.nextLine();
      for (int ni = 0; ni < n; ni++) {
        switch (seq.charAt(ni)) {
          case 'L':
            winStreak = 0;
            loseStreak++;
            break;
          case 'W':
            if (loseStreak > 0) {
              queue.offer(new Slot(loseStreak, (points > 0 ? 1 : 0)));
            }
            loseStreak = 0;
            winStreak++;
            points += (winStreak > 1 ? 2 : 1);
            break;
        }
      }
      if (loseStreak > 0) {
        queue.offer(new Slot(loseStreak, (points > 0 ? 0 : -1)));
      }
      Slot slot;
      while (k > 0 && queue.size() > 0) {
        slot = queue.poll();
        if (slot.sz <= k) {
          points += (slot.sz << 1) + slot.type;
          k -= slot.sz;
        } else {
          points += (k << 1) + Math.min(0, slot.type);
          k = 0;
        }
      }
      System.out.println(points);
    } catch (Exception e) {}
  }
}
