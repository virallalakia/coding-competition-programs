/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.rc.problemD_Candies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: C
 * Problem: Problem D (Candies)
 * Result: Time Limit Exceeded
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
      int _Q_ = SYS_IN.nextInt();
      SYS_IN.nextLine();
      int[] ip = new int[_N_];
      for (int i = 0; i < _N_; i++) {
        ip[i] = SYS_IN.nextInt();
      }
      SYS_IN.nextLine();

      int R = 0;
      for (int q = 0; q < _Q_; q++) {
        String command = SYS_IN.next("[QU]");
        int _I1_ = SYS_IN.nextInt();
        int _I2_ = SYS_IN.nextInt();
        SYS_IN.nextLine();
        switch (command) {
          case "U":
            ip[_I1_ - 1] = _I2_;
            break;
          case "Q":
            int c = 1;
            for (int i = _I1_ - 1; i < _I2_; i++) {
              R += (c++) * ip[i];
              if (++i < _I2_) {
                R -= (c++) * ip[i];
              }
            }
            break;
        }
      }
      return String.format("Case #%d: %d", t, R);
    } catch (Exception e) {
    }
    return String.format("Case #%d: %d", t, 0);
  }

}
