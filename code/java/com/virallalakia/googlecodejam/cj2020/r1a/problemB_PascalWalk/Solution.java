/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlecodejam.cj2020.r1a.problemB_PascalWalk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1a
 * Problem: Problem B (Pascal Walk)
 * Result: Set 1 (Pass), Set 2 (Pass)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      evaluateCase(t + 1, SYS_IN.nextInt());
      SYS_IN.nextLine();
    }
    SYS_IN.close();
  }

  private static void evaluateCase(final int t, int _N_) {
    try {
      System.out.println(String.format("Case #%d:", t));
      if (_N_ > 0) {
        System.out.println(String.format("%d %d", 1, 1));
        _N_--;
      }
      int colLastFlag = 0;
      for (int r = 1; _N_ > 0; r++) {
        if (r <= _N_) {
          _N_ -= r;
          //          System.out.println(String.format("%d %d", r + 1, r));
        } else {
          if (colLastFlag == 0) {
            colLastFlag = 1;
            r--;
          }
          //          System.out.println(String.format("%d %d", r + 1, r + 1));
          _N_--;
        }
        System.out.println(String.format("%d %d", r + 1, r + colLastFlag));
      }
    } catch (Exception e) {
    }
  }

}
