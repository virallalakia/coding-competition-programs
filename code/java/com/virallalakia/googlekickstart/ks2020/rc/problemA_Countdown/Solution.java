/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rc.problemA_Countdown;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: C
 * Problem: Problem A (Countdown)
 * Result: Pass
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t) {
    try {
      int _N_ = SYS_IN.nextInt();
      int _K_ = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] ip = new int[_N_];
      for (int i = 0; i < _N_; i++) {
        ip[i] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      int R = 0;
      for (int i = 0; i < _N_; i++) {
        if (ip[i] != _K_) {
          continue;
        }
        boolean f = true;
        for (int j = _K_ - 1; j >= 1; j--) {
          if (++i >= _N_ || ip[i] != j) {
            if (i < _N_) {
              i--;
            }
            f = false;
            break;
          }
        }
        if (f) {
          R++;
        }
      }
      return String.format("Case #%d: %d", t, R);
    } catch (Exception e) {
    }
    return String.format("Case #%d: %d", t, 0);
  }

}
