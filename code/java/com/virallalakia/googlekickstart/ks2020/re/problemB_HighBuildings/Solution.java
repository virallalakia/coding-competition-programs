/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 - Present Viral Lalakia                                 *
 ******************************************************************************
 */

package com.virallalakia.googlekickstart.ks2020.re.problemB_HighBuildings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * This is a solution for one of the problems for Google Kick Start 2020.
 * Competition: Google Kick Start 2020
 * Round: E
 * Problem: Problem B (High Buildings)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN =
      new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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
      int _A_ = SYS_IN.nextInt();
      int _B_ = SYS_IN.nextInt();
      int _C_ = SYS_IN.nextInt();
      SYS_IN.nextLine();

      _A_ -= _C_;
      _B_ -= _C_;

      int[] ans = null;
      if (_A_ >= 0
          && _B_ >= 0
          && _C_ > 0
          && _A_ + _B_ + _C_ <= _N_
          && (_C_ > 1 || _A_ != 0 || _B_ != 0 || _N_ == 1)) {
        ans = new int[_N_];
        for (int i = 0; i < _N_; i++) {
          ans[i] = 1;
        }
        if (_C_ == 1) {
          if (_B_ == 0) {
            ans[_N_ - 1] = _N_;
          } else {
            ans[_A_] = _N_;
          }
        } else {
          for (int i = 0; i < _C_ - 1; i++) {
            ans[_A_ + i] = _N_;
          }
          ans[_N_ - 1 - _B_] = _N_;
        }
        for (int i = 0; i < _A_; i++) {
          ans[i] = _N_ - _A_ + i;
        }
        for (int i = 0; i < _B_; i++) {
          ans[_N_ - i - 1] = _N_ - _B_ + i;
        }
      }
      if (ans != null) {
        return String.format(
            "Case #%d: %s",
            t, Arrays.stream(ans).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: IMPOSSIBLE", t);
  }
}
