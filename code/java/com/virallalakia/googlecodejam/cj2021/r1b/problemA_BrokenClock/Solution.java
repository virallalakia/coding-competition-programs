/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) (2021 - Present) Viral Lalakia                               *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2021.r1b.problemA_BrokenClock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2021.
 * Round: 1B
 * Problem: Problem A (Broken Clock)
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final long TOTAL_TICKS = 360 * 12 * 10_000_000_000L;
  private static final long QUARTER_TICKS = TOTAL_TICKS / 4;
  private static final long HOUR_TICKS = TOTAL_TICKS / 12;
  private static final long MINUTE_TICKS = HOUR_TICKS / 60;
  private static final long HOUR_HAND_TICK_UNIT = 1L; // not used really
  private static final long MINUTE_HAND_TICK_UNIT = 12L;
  private static final long SECOND_HAND_TICK_UNIT = 720L;

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    long _A_ = SYS_IN.nextLong();
    long _B_ = SYS_IN.nextLong();
    long _C_ = SYS_IN.nextLong();
    long h = 0L, m = 0L, s = 0L, ns = 0L;
    SYS_IN.nextLine();
    try {
      int combo;
      if ((combo = checkAndGetValidCase(_A_, _B_, _C_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _A_) % TOTAL_TICKS;
      } else if ((combo = checkAndGetValidCase(_A_, _C_, _B_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _A_) % TOTAL_TICKS;
      } else if ((combo = checkAndGetValidCase(_B_, _A_, _C_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _B_) % TOTAL_TICKS;
      } else if ((combo = checkAndGetValidCase(_B_, _C_, _A_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _B_) % TOTAL_TICKS;
      } else if ((combo = checkAndGetValidCase(_C_, _A_, _B_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _C_) % TOTAL_TICKS;
      } else if ((combo = checkAndGetValidCase(_C_, _B_, _A_)) != -1) {
        h = ((combo * QUARTER_TICKS) + _C_) % TOTAL_TICKS;
      }
      ns = h % 1000_000_000L;
      h /= 1000_000_000L;
      s = h % 60;
      h /= 60;
      m = h % 60;
      h /= 60;
      h = h % 12;
    } catch (Exception ignored) {
    }
    return String.format("Case #%d: %d %d %d %d", t, h, m, s, ns);
  }

  private static int checkAndGetValidCase(long h, long m, long s) {
    for (int i = 0; i < 4; i++) {
      if (s % SECOND_HAND_TICK_UNIT == 0 && m % MINUTE_HAND_TICK_UNIT == 0) {
        if (h % HOUR_TICKS == m / MINUTE_HAND_TICK_UNIT
            && m % MINUTE_TICKS == s / SECOND_HAND_TICK_UNIT) {
          return i;
        }
      }
      if (i < 3) {
        h = (h + QUARTER_TICKS) % TOTAL_TICKS;
        m = (m + QUARTER_TICKS) % TOTAL_TICKS;
        s = (s + QUARTER_TICKS) % TOTAL_TICKS;
      }
    }
    return -1;
  }
}
