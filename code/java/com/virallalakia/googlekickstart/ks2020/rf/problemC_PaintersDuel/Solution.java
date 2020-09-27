/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rf.problemC_PaintersDuel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: F
 * Problem: Problem C (Painters Duel) (Set 1)
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
      int s = SYS_IN.nextInt();
      int ra = SYS_IN.nextInt();
      int ca = SYS_IN.nextInt();
      int rb = SYS_IN.nextInt();
      int cb = SYS_IN.nextInt();
      int c = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int ans = (ra == 2 && ca == 2 ? 1 : (rb == 2 && cb == 2 ? 2 : 0));
      for (int ci = 0; ci < c; ci++) {
        if (SYS_IN.nextInt() == 2 && SYS_IN.nextInt() == 2) {
          ans = 3;
        }
        SYS_IN.nextLine();
      }

      if (s == 2) {
        switch (ans) {
          case 3:
            ans = 0;
            break;
          case 1:
            ans = Math.min(1, 2 - c);
            break;
          case 2:
            ans = - Math.min(1, 2 - c);
            break;
          default:
            ans = 2 - c;
        }
      } else {
        ans = 0;
      }
      System.out.printf("Case #%d: %d\n", t, ans);
    } catch (Exception e) {
    }
  }
}
